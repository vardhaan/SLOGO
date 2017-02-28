package commands;

import java.util.ArrayList;

public class LIST extends LongCommand{
	
	public LIST() {
		super();
		
	}
	
	@Override
	public void setReturnValue() {
		ArrayList<Integer> toRemove = new ArrayList<Integer>();
		for (int rem : toRemove) {
			subCommands.remove(rem);
		}
		for (int i=0;i<subCommands.size();i++) {
			subCommands.get(i).setReturnValue();
			returnValue = subCommands.get(i).getReturnValue();
		}
	}
	
	@Override
	public double executeCommand() {
		// TODO Auto-generated method stub
		return 0;
	}

}
