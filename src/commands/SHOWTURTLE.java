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
	public double executeCommand() {
		showTurtle = true;
		returnValue = 1;
		target.setShow(true);
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		
		return 1;
	}

}
