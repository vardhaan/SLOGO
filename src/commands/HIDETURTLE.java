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
	public void setReturnValue() throws ParameterNotEnoughException {
		//DO NOTHING
	}
	

	@Override
	public double executeCommand() {

		showTurtle = false;
		returnValue = 0;
		target.setShow(false);
		
		return 0;
	}

}
