/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
import exceptions.ParameterNotEnoughException;

public class ISSHOWING extends TurtleCommand {
	
	public ISSHOWING() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//DO NOTHING
	}
	
	@Override
	public double executeCommand() {
		returnValue = (target.showTurtle() == true)? 1 : 0;

		return returnValue;
	}
	
}