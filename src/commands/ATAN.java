/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class ATAN extends Command{
	public ATAN(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
			double degree = parameters.get(0);
			returnValue = Math.atan(degree);
			sendReturnToDependent();
		}
	}

	@Override
	public double executeCommand() {

		double degree = parameters.get(0);
		returnValue = Math.atan(degree);
		return returnValue;
	}

}