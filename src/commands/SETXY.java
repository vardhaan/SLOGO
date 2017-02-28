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

public class SETXY extends TurtleCommand {
	
	public SETXY() {
		super();
		expectedNumParameters = 2;
	}
	
	@Override
	public double executeCommand() {
	
		double x = parameters.get(0);
		double y = parameters.get(1);
		//the degree  that turtle turned
		returnValue = Math.sqrt(x *x + y * y);
		
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		Turtle target = getTurtle();
		target.setOverallXChange( x - target.getX());
		target.setOverallYChange(y - target.getY());
		return returnValue;
	}
	
}