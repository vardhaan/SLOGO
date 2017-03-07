/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
import exceptions.ParameterNotEnoughException;

public class YCOR extends TurtleCommand {

	public YCOR() {
		super();
		expectedNumParameters = 0;
	}


	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//DO NOTHING
	}

	@Override
	public double executeCommand() {
		returnValue = target.getY();
		return returnValue;
	}

}