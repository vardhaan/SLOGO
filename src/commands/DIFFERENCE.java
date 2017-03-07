/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class DIFFERENCE extends Command{
	public DIFFERENCE(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if(parameters.size() == expectedNumParameters){
			returnValue = parameters.get(0) - parameters.get(1);
		}
		sendReturnToDependent();
	}

	@Override
	public double executeCommand() {
		returnValue = (parameters.get(0) - parameters.get(1));
		return returnValue;
	}

}
