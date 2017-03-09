/**
 * 
 */
package commands;

import java.util.ResourceBundle;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class SETPENCOLOR extends TurtleCommand {


	public SETPENCOLOR(){
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

		target.setPenColorIndex((int)Math.round(parameters.get(0)));
		returnValue = parameters.get(0);

		return returnValue;
	}

}
