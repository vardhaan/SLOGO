package commands;

import java.util.ArrayList;

public class CommandEngine {

	private ArrayList<Command> commandQueue;
	
	public CommandEngine() {
		commandQueue = new ArrayList<Command>();
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
		if(commandsReadyToExecute()) {
			for (int i=0;i<commandQueue.size();i++) {
				Command c = commandQueue.get(i);
				Double ret = c.executeCommand(); //what to do with return value
			}
		} else {
			//TODO: THROW EXCEPTION
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
			commandQueue.add(commandIndex, toAdd);
		} else {
			commandQueue.add(toAdd);
		}
		
	}
	
	
	
}

