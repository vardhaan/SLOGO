/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
import exceptions.ParameterNotEnoughException;
import exceptions.PopUpException;
import turtles.Turtle;

public class ISPENDOWN extends TurtleCommand {
	
	public ISPENDOWN() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		try {
		Turtle target = getTurtle();
		returnValue = (target.isPenDown() == true)? 1 : 0;
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		return returnValue;
	}
	
}