package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class PENDOWN extends TurtleCommand {

	public PENDOWN(){
		super();
		expectedNumParameters = 0;
	}
	
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//do nothing
		if (parameters.size() == expectedNumParameters) {
			returnValue = 0;
			sendReturnToDependent();
		}
	}

	@Override
	public double executeCommand() {
		penDown = true;
		returnValue = 1;		
		target.setPenDown(true);

		return returnValue;
	}
}
