package commands;

import java.util.ArrayList;

import turtles.Turtle;

public class FORWARD extends TurtleCommand {

	
	
	public FORWARD() {
		super();
		expectedNumParameters = 1;
	}
	

	
	@Override
	public double executeCommand() {
		setReturnValue();
		Turtle target = getTurtle();
		target.setOverallXChange(returnValue);
		return returnValue;
	}
	
	
}
