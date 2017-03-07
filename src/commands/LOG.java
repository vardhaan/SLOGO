/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class LOG extends Command{
	public LOG(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {

			returnValue =(parameters.get(0) == 0)? 0 : Math.log(Math.abs(parameters.get(0)));

			sendReturnToDependent();
		}
	}

	@Override
	public double executeCommand() {
		double degree = parameters.get(0);
		//here we will return log of 0 as 0
		returnValue =(degree == 0)? 0 : Math.log(degree);

		return returnValue;
	}

}