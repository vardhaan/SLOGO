/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
import exceptions.ParameterNotEnoughException;
import turtles.Turtle;

public class XCOR extends TurtleCommand {
	
	public XCOR() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		returnValue = target.getX();
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		
		return returnValue;
	}
	
}