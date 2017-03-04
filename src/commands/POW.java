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
public class POW extends Command{
	public POW(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		try{
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = Math.pow(x, y);
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		
		return returnValue;
	}

}