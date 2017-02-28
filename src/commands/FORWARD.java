package commands;

import java.util.ArrayList;

import exceptions.ParameterNotEnoughException;
import turtles.Turtle;

public class FORWARD extends TurtleCommand {

	
	
	public FORWARD() {
		super();
		expectedNumParameters = 1;
	}
	

	
	@Override
	public double executeCommand() {
		
		Turtle target = getTurtle();
		target.setOverallXChange(returnValue);
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		
		return returnValue;
	}
	
	
}
