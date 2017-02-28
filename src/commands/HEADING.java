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

public class HEADING extends TurtleCommand {
	
	public HEADING() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		Turtle target = getTurtle();
		returnValue = target.getHeading();
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		
		return returnValue;
	}
	
}