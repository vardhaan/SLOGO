package commands;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.ParameterNotEnoughException;
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
	
	private void changeVariablesToValues() {
		for (int i=0;i<commandQueue.size();i++) {
			Command c = commandQueue.get(i);
			if (c instanceof VARIABLE) {
				VARIABLE v = (VARIABLE) c;
				v.manualSetReturn(getValueForVariable(v.getName()));
			}
		}
	}
	
	public Double getValueForVariable(String variableName) {
		if (variables.containsKey(variableName)) {
			return variables.get(variableName);
		}
		return 0.0; //MAGIC CONSTANT
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
		addVariablesToMap();
		changeVariablesToValues();
	}
	
	public boolean commandsReadyToExecute() {
		for (Command c : commandQueue) {
			if (c.getNumParameters() != c.getParameters().size() + c.numCommandAsParam) {
				System.out.println("thic is cNumPar: " + c.getNumParameters() + " " + (c.getParameters().size()+c.numCommandAsParam));

				return false;
			}
		}
		
		return true;
	}
	
	public void executeCommands() throws Exception {
		setAllReturnValues(); 
		addVariablesToMap();
		changeVariablesToValues();
		System.out.println("reaches here");
		if(commandsReadyToExecute()) {
			for (int i=0;i<commandQueue.size();i++) {
				System.out.println("this is i: " + i);
				Command c = commandQueue.get(i);
				if (c instanceof TurtleCommand) {
					TurtleCommand tc = (TurtleCommand) c;
					tc.setTurtle(tViewer.getTurtle(0));
				}
				Double ret = c.executeCommand(); //what to do with return value
			}
		} else {
			//TODO: THROW EXCEPTION
		}
	}
	
	private void setAllReturnValues() {
		for (int i=0;i<commandQueue.size();i++) {
			Command c = commandQueue.get(i);
			try {
				c.setReturnValue();
			} catch (ParameterNotEnoughException e) {
				
				e.getMessage();
			}
		}
	}
	
	
	private void addVariablesToMap() {
		for (int i=0;i<commandQueue.size();i++) {
			Command c = commandQueue.get(i);
			if (c instanceof MAKE) {
				MAKE m = (MAKE) c;
				variables.put(m.getVariableName(), m.getReturnValue());
			}
		}
	}
	
	
	public void addCommand(Command toAdd) {
		int commandIndex = -1;
		for (int i=0;i<commandQueue.size();i++) {
			if (commandQueue.get(i).needsCommand()) {
				commandIndex = i;
			}
		}
		if (commandIndex!=-1) {
			System.out.println("Adding to command at " + commandIndex);
			if (commandQueue.get(commandIndex) instanceof ListContainingCommand) {
				ListContainingCommand lcc = (ListContainingCommand) commandQueue.get(commandIndex);
				if (lcc.addCommandWithin()) {
					lcc.addCommand(toAdd);
				} else {
					toAdd.setDependent(lcc);
					commandQueue.add(commandIndex, toAdd);
					lcc.incrementNumCommAsParam();
				}
			} else {
				if (commandQueue.get(commandIndex) instanceof LongCommand) {
					commandQueue.get(commandIndex).addCommand(toAdd);
				} else {
					toAdd.setDependent(commandQueue.get(commandIndex));
					commandQueue.add(commandIndex, toAdd);
				}
			}
			
		} else {
			commandQueue.add(toAdd);
		}
		
	}
	
	public void addParameter(Double d) {
		int commandIndex = -1;
		for (int i=commandQueue.size()-1;i>-1;i--) {
			if (commandQueue.get(i).needsParameter()) {
				commandIndex = i;
			}
			
		}
		if (commandIndex!=-1) {
			commandQueue.get(commandIndex).addParameter(d);
			System.out.println("Adding param to command at: " + commandIndex);
		} else {
			//TODO: THROW EXCEPTION: TOO MANY PARAMETERS
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

