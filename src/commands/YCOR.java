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

public class YCOR extends TurtleCommand {
	
	public YCOR() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		Turtle target = getTurtle();
		returnValue = target.getY();
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		
		return returnValue;
	}
	
}