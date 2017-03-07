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
	public void setReturnValue() throws ParameterNotEnoughException {
		//DO NOTHING
	}

	@Override
	public double executeCommand() {
		returnValue = Math.PI;

		return returnValue;
	}

}