/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class QUOTIENT extends Command{
	public QUOTIENT(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = (y==0)? 0 : x / y;
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
		
			e.getMessage();
		}
		
		return returnValue;
	}

}