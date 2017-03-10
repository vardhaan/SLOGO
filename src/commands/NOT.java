/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class  NOT extends Command{
	public NOT(){
		super();
		expectedNumParameters = 1;
	}


	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
			returnValue = (parameters.get(parameters.size()-1) == 0) ? 1 : 0;
			//System.out.println("NOT sets this return val" + returnValue);
			sendReturnToDependent();
		} 
	}

	@Override
	public double executeCommand() {

		double x = parameters.get(0);
		returnValue = (x == 0)? 1 : 0;

		return returnValue;
	}

}
