package commands;

import exceptions.ParameterNotEnoughException;
import turtles.Turtle;

/**
 * set the color of the pen
 * @author Zhiyong
 *
 */
public class SETPENCOLOR extends TurtleCommand {


	public SETPENCOLOR(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
			returnValue = parameters.get(0);
			sendReturnToDependent();
		}
	}

	@Override
	public double executeCommand() {
		for (Turtle t : target) {
			t.setPenColorIndex((int)Math.round(parameters.get(0)));
		}
		
		returnValue = parameters.get(0);

		return returnValue;
	}

}
