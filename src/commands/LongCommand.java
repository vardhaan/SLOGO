package commands;

import java.util.ArrayList;

import turtles.Turtle;

public abstract class LongCommand extends Command {
	 protected ArrayList<Command> subCommands;
	 protected Double expectedNumCommands;
	

	public LongCommand() {
		super();
		subCommands = new ArrayList<Command>();
		expectedNumCommands = Double.MAX_VALUE;
	}
	
	
	
	
	// COULD BE AUTOFAIL STATEMENT HERE???
	@Override
	public boolean needsParameter() {
		for (int i=0;i<subCommands.size();i++) {
			if (subCommands.get(i).needsParameter()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void addParameter(Double d) {
		//System.out.println("param is being added to subcommand");
		int index = 0;
		for (int i=0;i<subCommands.size();i++) {
			if (subCommands.get(i).needsParameter()) {
				index = i;
			}
		}
		subCommands.get(index).addParameter(d);
	}
	
	@Override 
	public boolean needsCommand() {
		return !(subCommands.size() == expectedNumCommands);
	}
	
	@Override
	public void addCommand(Command toAdd) {
		int index = -1;
		for (int i=0;i<subCommands.size();i++) {
			if (subCommands.get(i).needsCommand()) {
				index = i;
			}
		}
		System.out.println(toAdd.getClass().getSimpleName() + " was added to position " + index + " within LIST");
		if (index != -1) {
			System.out.println("Command at index " + index  +" was " + subCommands.get(index).getClass().getSimpleName());
			Command dep = subCommands.get(index);
			if (!(dep instanceof LongCommand)) {
				subCommands.add(index, toAdd);
			}
			dep.addCommand(toAdd);
		} else {
			subCommands.add(toAdd);
		}
	}




	public void setTurtle(Turtle turtle) {
		// TODO Auto-generated method stub
		for (int i=0;i<subCommands.size();i++) {
			Command c = subCommands.get(i);
			c.setTurtle(turtle);
		}
		
	}
	
	
	
	
}
