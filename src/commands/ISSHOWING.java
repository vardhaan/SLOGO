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

public class ISSHOWING extends TurtleCommand {
	
	public ISSHOWING() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		try {
		returnValue = (target.showTurtle() == true)? 1 : 0;
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		return returnValue;
	}
	
}