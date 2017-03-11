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
		returnValue = target.get(target.size()-1).getX();
		sendReturnToDependent();
	}

	@Override
	public double executeCommand() {
		returnValue = target.get(target.size()-1).getX();

		return returnValue;
	}

}