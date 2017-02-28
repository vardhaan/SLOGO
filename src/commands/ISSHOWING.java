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

public class ISSHOWING extends TurtleCommand {
	
	public ISSHOWING() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		Turtle target = getTurtle();
		returnValue = (target.showTurtle() == true)? 1 : 0;
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		
		return returnValue;
	}
	
}