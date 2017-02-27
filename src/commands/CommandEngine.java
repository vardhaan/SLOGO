package commands;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandEngine {

	private ArrayList<Command> commandQueue;
	private HashMap<String, Double> variables;
	
	public CommandEngine() {
		commandQueue = new ArrayList<Command>();
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
			Command next = commandQueue.get(0);
			double returnVal = next.executeCommand();
			return returnVal;
		} else {
			//TODO: GET UPDATE TO STOP RUNNING SOMEHOW
			return 0.0;
		}
	}
	
	public boolean commandsReadyToExecute() {
		for (Command c : commandQueue) {
			if (c.getNumParameters() != c.getParameters().size()) {
				return false;
			}
		}
		return true;
	}
	
	public void executeCommands() {
		setAllReturnValues(); 
		addVariablesToMap();
		changeVariablesToValues();
		if(commandsReadyToExecute()) {
			for (int i=0;i<commandQueue.size();i++) {
				Command c = commandQueue.get(i);
				Double ret = c.executeCommand(); //what to do with return value
			}
		} else {
			//TODO: THROW EXCEPTION
		}
	}
	
	private void setAllReturnValues() {
		for (int i=0;i<commandQueue.size();i++) {
			Command c = commandQueue.get(i);
			c.setReturnValue();
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
			if (commandQueue.get(i).getParameters().size()!=commandQueue.get(i).getNumParameters()) {
				commandIndex = i;
			}
		}
		if (commandIndex!=-1) {
			toAdd.setDependent(commandQueue.get(commandIndex));
			commandQueue.add(commandIndex, toAdd);
		} else {
			commandQueue.add(toAdd);
		}
		
	}
	
	public void addParameter(Double d) {
		int commandIndex = -1;
		for (int i=0;i<commandQueue.size();i++) {
			if (commandQueue.get(i).getParameters().size() != commandQueue.get(i).getNumParameters()) {
				commandIndex = i;
			}
		}
		if (commandIndex!=-1) {
			commandQueue.get(commandIndex).getParameters().add(d);
		} else {
			//TODO: THROW EXCEPTION: TOO MANY PARAMETERS
		}
	}
	
	
	
}

