package commands;

import java.util.ArrayList;

import exceptions.ParameterNotEnoughException;

public class LIST extends LongCommand{
	
	public LIST() {
		super();
	}
	
	@Override
	public void addCommand(Command toAdd) {
		if (toAdd instanceof LISTEND) {
			expectedNumCommands =  subCommands.size() * 1.0;
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
		for (int i=0;i<subCommands.size();i++) {
			try {
				subCommands.get(i).setReturnValue();
			} catch (ParameterNotEnoughException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i=0;i<subCommands.size();i++) {
			Double d = subCommands.get(i).executeCommand();
		}
		return 0;
	}

}
