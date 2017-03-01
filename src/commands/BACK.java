package commands;

import exceptions.ParameterNotEnoughException;
import turtles.Turtle;

public class BACK extends TurtleCommand {
	
	public BACK() {
		super();
		expectedNumParameters = 1;
	}
	
	
	

	@Override
	public double executeCommand() {
	
		returnValue = parameters.get(0);
		
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		
		double degree = target.getHeading();
		double y = Math.sin(degree) * returnValue;
		double x = Math.cos(degree) * returnValue;
		target.setOverallXChange(-x);
		target.setOverallYChange(y);
		System.out.println(target.getX());
		return returnValue;
	}
	
}