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

public class TOWARDS extends TurtleCommand {
	
	public static final double DEGREEOFPI = 180;




	public TOWARDS() {
		super();
		expectedNumParameters = 2;
	}
	
	
	

	@Override
	public double executeCommand() {
	
		double x = parameters.get(0);
		double y = parameters.get(1);
		double sinValue = (y == 0 && x == 0)? 0 : x / Math.sqrt(x * x + y * y);
		//the degree  that turtle turned
		returnValue = Math.asin(sinValue) * DEGREEOFPI / Math.PI;
		
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