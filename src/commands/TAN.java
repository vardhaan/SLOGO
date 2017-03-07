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
public class TAN extends Command{
	public TAN(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		try{
		double degree = parameters.get(0);
		returnValue = (degree %  (Math.PI/2) == 0) ? 0 :Math.tan(degree);
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		return returnValue;
	}

}
