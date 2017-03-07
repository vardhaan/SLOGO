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
public class DIFFERENCE extends Command{
	public DIFFERENCE(){
		super();
		expectedNumParameters = 2;
	}
	
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		returnValue = parameters.get(0) - parameters.get(1);
		sendReturnToDependent();
	}

	@Override
	public double executeCommand() {
		try {
		setReturnValue();
		} catch (ParameterNotEnoughException e) {
			
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		return returnValue;
	}

}
