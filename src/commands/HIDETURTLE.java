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
		returnValue = 0;
		sendReturnToDependent();
	}
	

	@Override
	public double executeCommand() {

		showTurtle = false;
		returnValue = 0;
		for (Turtle t : target) {
			t.setShow(false);
		}
		
		
		return 0;
	}

}
