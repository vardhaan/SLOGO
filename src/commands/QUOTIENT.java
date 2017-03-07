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
public class QUOTIENT extends Command{
	public QUOTIENT(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		try{
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = (y==0)? 0 : x / y;
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		
		return returnValue;
	}

}