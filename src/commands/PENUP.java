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
public class PENUP extends TurtleCommand {

	public PENUP(){
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

		penDown = false;
		returnValue = 0;
		for (Turtle t : target) {
			t.setPenDown(false);

		}
		//System.out.println("Pen is up");
		return returnValue;
	}

}
