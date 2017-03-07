/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
import exceptions.ParameterNotEnoughException;

public class SETHEADING extends TurtleCommand {

	public SETHEADING() {
		super();
		expectedNumParameters = 1;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
			returnValue = parameters.get(0) ;

			sendReturnToDependent();
		}
	}


	@Override
	public double executeCommand() {
		returnValue = parameters.get(0);
		target.setHeading(returnValue);
		return returnValue;


	}

}