package commands;

import exceptions.ParameterNotEnoughException;

public class TURTLES extends TurtleCommand{
	public TURTLES(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//do nothing
	}
	@Override
	public double executeCommand() {
		returnValue = turtles.size();
		return returnValue;
	}
}
