/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class SETPENSIZE extends Command {
	
	public SETPENSIZE(){
		super();
		expectedNumParameters = 1;
	}
	
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
			returnValue = parameters.get(0);
			sendReturnToDependent();
		}
	}
	
	@Override
	public double executeCommand() {
		returnValue = parameters.get(0);
		target.setPenSize((int)Math.round(returnValue));
			
		return returnValue;
	}

}
