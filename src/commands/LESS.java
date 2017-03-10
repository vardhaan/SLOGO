/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class LESS extends Command{
	public LESS(){
		super();
		expectedNumParameters = 2;
	}
	
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
				returnValue = (parameters.get(0) < parameters.get(1))? 1 : 0;
				//System.out.println("less set ret to be this: " + returnValue);
				sendReturnToDependent();
		}
	}

	@Override
	public double executeCommand() {

		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = (x < y)? 1 : 0;
		
		return returnValue;
	}

}
