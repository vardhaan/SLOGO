/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class PI extends Command{
	public PI(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		returnValue = Math.PI;
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			
			e.getMessage();
		}
		
		return returnValue;
	}

}