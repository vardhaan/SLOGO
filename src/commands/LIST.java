package commands;

import java.util.ArrayList;

public class LIST extends LongCommand{
	
	public LIST() {
		super();
	}
	
	@Override
	public void addCommand(Command toAdd) {
		if (toAdd instanceof LISTEND) {
			expectedNumParameters = subCommands.size();
		} else {
			super.addCommand(toAdd);
		}
	}
	
	@Override
	public void setReturnValue() {
		System.out.println(subCommands.size());
		returnValue = subCommands.get(subCommands.size()-1).getReturnValue();
	}
	
	@Override
	public double executeCommand() {
		// TODO Auto-generated method stub
		return 0;
	}

}
