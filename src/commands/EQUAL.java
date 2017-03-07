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
public class EQUAL extends Command{
	public EQUAL(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		try {
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = (x == y)? 1 : 0;
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		return returnValue;
	}

}