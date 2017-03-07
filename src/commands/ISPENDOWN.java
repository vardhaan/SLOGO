/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
import exceptions.ParameterNotEnoughException;

public class ISPENDOWN extends TurtleCommand {
	
	public ISPENDOWN() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//DO NOTHING
	}
	
	@Override
	public double executeCommand() {
		returnValue = (target.isPenDown() == true)? 1 : 0;

		return returnValue;
	}
	
}