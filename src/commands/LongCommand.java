package commands;

import java.util.ArrayList;

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
		if (index != -1) {
			Command dep = subCommands.get(index);
			if (!(dep instanceof LongCommand)) {
				subCommands.add(index, toAdd);
			}
			dep.addCommand(toAdd);
		} else {
			subCommands.add(toAdd);
		}
	}
	
	
	
	
}
