/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class POW extends Command{
	public POW(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = Math.pow(x, y);
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {

			e.getMessage();
		}
		
		return returnValue;
	}

}