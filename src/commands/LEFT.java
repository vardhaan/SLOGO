/**
 * 
 */
package commands;

public class LEFT extends TurtleCommand {

	public LEFT() {
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		returnValue = parameters.get(0);
		target.setHeading(target.getHeading() - returnValue);
		target.setX(target.getX());
		target.setY(target.getY());
		
		return returnValue;
	}

}