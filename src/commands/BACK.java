package commands;

import exceptions.ParameterNotEnoughException;
import exceptions.PopUpException;
import turtles.Turtle;

public class BACK extends TurtleCommand {
	
	public BACK() {
		super();
		expectedNumParameters = 1;
	}
	
	@Override
	public double executeCommand() {
	
		FORWARD fd = new FORWARD();
		
		returnValue = parameters.remove(0);
		parameters.add(-returnValue);
		fd.executeCommand();
		return returnValue;
	}
	
}