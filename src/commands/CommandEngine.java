package commands;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.MyException;
import exceptions.ParameterNotEnoughException;
import exceptions.ParameterTooManyException;
import exceptions.PopUpException;
import turtles.TurtleViewer;

public class CommandEngine {

	public ArrayList<Command> commandQueue;
	private HashMap<String, Double> variables;
	private HashMap<String, Command> methods;
	private TurtleViewer tViewer;
	protected int commandExecuteIndex = 0;
	
	public CommandEngine() {
		commandQueue = new ArrayList<Command>();
		variables = new HashMap<String, Double>();
		methods = new HashMap<String, Command>();
	}
	
	
	public void setTurtleViewer(TurtleViewer tv) {
		tViewer = tv;
	}
	
	
	public Double getValueForVariable(String variableName) {
		if (variables.containsKey(variableName)) {
			return variables.get(variableName);
		}
		return 0.0; 
	}
	
	public double executeNextCommand() {
		if (!commandQueue.isEmpty()) {
			Command next = commandQueue.get(commandExecuteIndex);
			double returnVal = next.executeCommand();
			commandExecuteIndex++;
			return returnVal;
		} else {
			//TODO: GET UPDATE TO STOP RUNNING SOMEHOW
			return 0.0;
		}
	}
	
	public void initializeForExecution() {
		setAllReturnValues(); 
		//addVariablesToMap();
		//changeVariablesToValues();
	}
	
	public boolean commandsReadyToExecute() {
		//////System.out.println(commandQueue.size() + " this is cq size");
		for (Command c : commandQueue) {
			//System.out.println("This is the command to check: " + c.getClass().getSimpleName());
			//System.out.println(c.getNumParameters() + " " + c.getParameters().size() + " " + c.numCommandAsParam);
			if (c.getNumParameters() != c.getParameters().size() + c.numCommandAsParam) {
				//////System.out.println("thic is cNumPar: " + c.getNumParameters() + " " + (c.getParameters().size()+c.numCommandAsParam) + " " + c.getParameters().size());

				return false;
			}
		}
		
		return true;
	}
	
	public void executeCommands() throws Exception {
		//System.out.println("----------------------------------------------------------------");
		//System.out.println(commandQueue.size());
		//////System.out.println("reaches here");
		if(commandsReadyToExecute()) {
			//System.out.println("Ready to execute");
			for (int i=0;i<commandQueue.size();i++) {
				//////System.out.println("this is i: " + i);
				Command c = commandQueue.get(i);
				System.out.println(tViewer.getTurtleList().size() + " is size of turt list");
				c.setTurtle(tViewer.getTurtleList());
				
				
				
				//TODO:Zhiyong, for the TELL command, the TurtleCommand only will be
				//executed by the turtles in the TELL list
				
				
				
				Double ret = c.executeCommand(); //what to do with return value
			}
		} else {
			//TODO: THROW EXCEPTION
			//System.out.println("exceptions coming from here");
			MyException e = new ParameterNotEnoughException();
				PopUpException p = new PopUpException(e.getMessage());
				p.showMessage();
			
		}
	}
	
	private void setAllReturnValues() {
		for (int i=0;i<commandQueue.size();i++) {
			System.out.println("setting retval for: " + commandQueue.get(i).getClass().getSimpleName());
			Command c = commandQueue.get(i);
			//System.out.println(c.getClass().getSimpleName() + " is the command that is being retvalset");
			try {
				c.setReturnValue();
			} catch (ParameterNotEnoughException e) {
				//System.out.println("this should be the culprit------------------------------------------------------");
				PopUpException p = new PopUpException(e.getMessage());
				p.showMessage();
			}
		}
	}
	
	
	
	
	
	public void addCommand(Command toAdd) {
		toAdd.setTurtleViewer(tViewer);
		if(toAdd instanceof UserDefinedCommand) {
			UserDefinedCommand udc = (UserDefinedCommand) toAdd;
		}
		System.out.println(toAdd.getClass().getSimpleName());
		toAdd.addVariableSet(variables);
		int commandIndex = -1;
		for (int i=commandQueue.size()-1;i>=0;i-=1) {
			if (commandQueue.get(i).needsCommand()) {
				commandIndex = i;
			}
		}
		if (commandIndex!=-1) {
			if (commandQueue.get(commandIndex) instanceof ListContainingCommand) {
				ListContainingCommand lcc = (ListContainingCommand) commandQueue.get(commandIndex);
				if (lcc.addCommandWithin(toAdd)) {
					lcc.addCommand(toAdd);
				} else {
					toAdd.setDependent(lcc);
					commandQueue.add(commandIndex, toAdd);
					
				}
			} else {
				if (commandQueue.get(commandIndex) instanceof LongCommand ) {
					commandQueue.get(commandIndex).addCommand(toAdd);
				} else {
					if (commandQueue.get(commandIndex) instanceof MAKE && toAdd instanceof VARIABLE) {
						//System.out.println("SHOULD BE TRIGGERING 2 times!");
						commandQueue.get(commandIndex).addCommand(toAdd);
					} else {
						toAdd.setDependent(commandQueue.get(commandIndex));
						commandQueue.add(commandIndex, toAdd);
					}
				}
			}
			
		} else {
			commandQueue.add(toAdd);
		}
		
	}
	

	
	public void addParameter(Double d) {
		//System.out.println("this is when parameter is being added");
		int commandIndex = -1;
		for (int i=commandQueue.size()-1;i>-1;i--) {
			if (commandQueue.get(i).needsParameter()) {
				commandIndex = i;
			}
			
		}
		if (commandIndex!=-1) {
			//System.out.println("Adding param " + d + " to command " + commandQueue.get(commandIndex).getClass().getSimpleName());

			commandQueue.get(commandIndex).addParameter(d);
		} else {
			//TODO: THROW EXCEPTION: TOO MANY PARAMETERS
			MyException e = new ParameterTooManyException ();
			
				PopUpException p = new PopUpException(e.getMessage());
				p.showMessage();
			
		}
	}
	
	
	public Command getMostRecentOfType(String type) throws ClassNotFoundException {
		Class<?> clazz = Class.forName(type);
		Command mostRecent = null;
		
		for (int i=0;i<commandQueue.size();i++) {
			if (clazz.isInstance(commandQueue.get(i))) {
				mostRecent = commandQueue.get(i);
			}
		}
		return mostRecent; //error check in receiving method
	}
	
	public void reset() {
		commandQueue = new ArrayList<Command>();
		variables = new HashMap<String, Double>();
	}
	
	
}