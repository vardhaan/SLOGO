/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;
import turtles.Turtle;

/**
 * @author Zhiyong
 *
 */
public class SHOWTURTLE extends TurtleCommand{

	public SHOWTURTLE(){
		super();
		expectedNumParameters = 0;
	}
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//DO NOTHING
		returnValue = 1;
		sendReturnToDependent();
	}

	@Override
	public double executeCommand() {
		showTurtle = true;
		returnValue = 1;
		for (Turtle t : target) {
			t.setShow(true);
		}

		return 1;
	}

}
