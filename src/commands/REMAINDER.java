/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class REMAINDER extends Command{
	public REMAINDER(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
			returnValue = (parameters.get(0) % parameters.get(1));

			sendReturnToDependent();
		}
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = x % y;

		return returnValue;
	}

}