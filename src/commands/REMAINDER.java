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
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = x % y;
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
		
			e.getMessage();
		}
		
		return returnValue;
	}

}