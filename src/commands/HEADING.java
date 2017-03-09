/**
 * 
 */
package commands;

public class HEADING extends TurtleCommand {
	
	public HEADING() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		returnValue = target.getHeading();
		return returnValue;
	}
	
}