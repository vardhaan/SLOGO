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
public class MINUS extends Command{
	public MINUS(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		try{
		double x = parameters.get(0);
		returnValue = -x ;
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		return returnValue;
	}

}