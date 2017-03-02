/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;
import exceptions.PopUpException;

/**
 * @author Zhiyong
 *
 */
public class ATAN extends Command{
	public ATAN(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		
		try {
			double degree = parameters.remove(0);
			returnValue = Math.atan(degree);
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		return returnValue;
	}

}