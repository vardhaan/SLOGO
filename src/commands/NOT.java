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
	public void setReturnValue() {
		Double d = executeCommand();
		if (dependent!=null) {
			sendReturnToDependent();

		}
	}
	
	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		returnValue = (x == 0)? 1 : 0;
		
		return returnValue;
	}

}
