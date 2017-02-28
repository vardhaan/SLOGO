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

public class ISPENDOWN extends TurtleCommand {
	
	public ISPENDOWN() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		Turtle target = getTurtle();
		returnValue = (target.isPenDown() == true)? 1 : 0;
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		
		return returnValue;
	}
	
}