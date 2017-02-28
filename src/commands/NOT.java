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
	public double executeCommand() {
		double x = parameters.get(0);
		returnValue = (x == 0)? 1 : 0;
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		
		return returnValue;
	}

}
