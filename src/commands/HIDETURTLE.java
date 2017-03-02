/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;
import exceptions.PopUpException;
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
		try {
		showTurtle = false;
		returnValue = 0;
		Turtle turtle = getTurtle();
		turtle.setShow(false);
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		return 0;
	}

}
