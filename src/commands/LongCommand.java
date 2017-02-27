package commands;

import java.util.ArrayList;

public abstract class LongCommand extends Command {
	protected ArrayList<Command> subCommands;

	public LongCommand() {
		super();
		subCommands = new ArrayList<Command>();
		expectedNumParameters = Double.MAX_VALUE;
	}
	
	
	
	
	// COULD BE AUTOFAIL STATEMENT HERE???
	@Override
	public boolean needsParameter() {
		if (needsCommand() == false) {
			return false;
		}
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
		return !(subCommands.size() == expectedNumParameters);
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
			checkIfListDone();
		}
	}
	
	private void checkIfListDone() {
		if (subCommands.get(subCommands.size()-1) instanceof LISTEND) {
			subCommands.remove(subCommands.get(subCommands.size()-1));
		}
		expectedNumParameters = subCommands.size();
	}
}
