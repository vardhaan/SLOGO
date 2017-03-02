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
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		
		return returnValue;
	}

}