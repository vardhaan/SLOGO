package commands;

import turtles.Turtle;

public class BACK extends TurtleCommand {
	
	public BACK() {
		super();
		expectedNumParameters = 1;
	}
	
	
	

	@Override
	public double executeCommand() {
		// TODO Auto-generated method stub
		setReturnValue();
		Turtle target = getTurtle();
		double degree = target.getHeading();
		double y = Math.sin(degree) * returnValue;
		double x = Math.cos(degree) * returnValue;
		target.setOverallXChange(x);
		target.setOverallYChange(y);
		return 0;
	}

}
