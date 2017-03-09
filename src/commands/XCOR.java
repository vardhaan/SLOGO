/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
import exceptions.ParameterNotEnoughException;

public class XCOR extends TurtleCommand {

	public XCOR() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//DO NOTHING
	}

	@Override
	public double executeCommand() {
		returnValue = target.getX();

		return returnValue;
	}

}