package commands;

import turtles.Turtle;

public class FORWARD extends TurtleCommand {

	public FORWARD() {
		super();
		expectedNumParameters = 1;
	}
	

	@Override
	public double executeCommand() {
		Turtle nextExec = null;
		returnValue = parameters.get(0);
		for (Turtle t : target) {
			ForwardBackHelper f = new ForwardBackHelper();
			f.getHelp(t, -returnValue);
		}
		
		
		return returnValue;
	}


}