package commands;

import exceptions.ParameterNotEnoughException;

public class TURTLES extends TurtleCommand {

	public TURTLES() {
		super();
		expectedNumParameters = 0;
	}
	
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		returnValue = tv.getTurtleList().size();
		sendReturnToDependent();
	}
	
	
	@Override
	public double executeCommand() {
		// TODO Auto-generated method stub
		System.out.println(returnValue);
		return returnValue;
	}

}
