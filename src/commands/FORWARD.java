package commands;

import exceptions.ParameterNotEnoughException;
import turtles.Turtle;

public class FORWARD extends TurtleCommand {

	
	
	public FORWARD() {
		super();
		expectedNumParameters = 1;
	}
	

	
	@Override
	public double executeCommand() {
		
		
		returnValue = parameters.get(0);
		
		/*double degree = target.getHeading();
		double y = Math.sin(degree) * returnValue;
		double x = Math.cos(degree) * returnValue;
		target.setOverallXChange(x);
		target.setOverallYChange(-y);*/
		target.setX(target.getX() + returnValue);
		System.out.println("This is new x: " + target.getX());
		
		
		return returnValue;
	}
	
	
}