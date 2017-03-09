/**
 * 
 */
package commands;

public class RIGHT extends TurtleCommand {

	public RIGHT() {
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		returnValue = parameters.get(0);
		target.setHeading(target.getHeading() + returnValue);

		return returnValue;
	}

}