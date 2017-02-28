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

public class RIGHT extends TurtleCommand {
	
	public RIGHT() {
		super();
		expectedNumParameters = 1;
	}
	
	@Override
	public double executeCommand() {
	
		returnValue = parameters.get(0);
		
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		Turtle target = getTurtle();
		double degree = target.getHeading();
		target.setOverallHeadingChange(-degree);
		return returnValue;
	}
	
}