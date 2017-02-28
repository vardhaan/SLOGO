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
public class HIDETURTLE extends TurtleCommand{
	
	public HIDETURTLE(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		showTurtle = false;
		returnValue = 0;
		Turtle turtle = getTurtle();
		turtle.setShow(false);
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		
		return 0;
	}

}
