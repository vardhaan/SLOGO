package commands;

import exceptions.ParameterNotEnoughException;
import turtles.Turtle;

/**
 * @author Zhiyong
 *
 */
public class PENDOWN extends TurtleCommand {

	public PENDOWN(){
		super();
		expectedNumParameters = 0;
	}
	
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
			returnValue = 0;
			sendReturnToDependent();
		}
	}

	@Override
	public double executeCommand() {
		penDown = true;
		returnValue = 1;	
		for (Turtle t : target) {
			t.setPenDown(true);

		}

		return returnValue;
	}
}
