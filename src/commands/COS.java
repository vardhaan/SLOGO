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
public class COS extends Command{
	public COS(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		try {
		double degree = parameters.get(0);
		returnValue = Math.cos(degree);
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
				
				PopUpException p = new PopUpException(e.getMessage());
				p.showMessage();
		}
		
		return returnValue;
	}

}