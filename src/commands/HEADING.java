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
	public void setReturnValue() {
		returnValue = target.get(target.size()-1).getHeading();
		sendReturnToDependent();
	}

	@Override
	public double executeCommand() {
		returnValue = target.get(target.size()-1).getHeading();
		return returnValue;
	}
	
}