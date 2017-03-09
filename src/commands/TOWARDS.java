/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
import exceptions.ParameterNotEnoughException;

public class TOWARDS extends TurtleCommand {

	public static final double DEGREEOFPI = 180;

	public TOWARDS() {
		super();
		expectedNumParameters = 2;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
			double x = parameters.get(0);
			double y = parameters.get(1);
			double sinValue = (y == 0 && x == 0)? 0 : x / Math.sqrt(x * x + y * y);
			//the degree  that turtle turned
			returnValue = Math.asin(sinValue) * DEGREEOFPI / Math.PI;		

			sendReturnToDependent();
		}
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		double sinValue = (y == 0 && x == 0)? 0 : x / Math.sqrt(x * x + y * y);
		//the degree  that turtle turned
		returnValue = Math.asin(sinValue) * DEGREEOFPI / Math.PI;		
		target.setX( x);
		target.setY(y);
		return returnValue;
	}

}