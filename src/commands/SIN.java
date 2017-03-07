/**
 * 
 */
package commands;

import java.util.Random;

import exceptions.ParameterNotEnoughException;
import exceptions.PopUpException;

/**
 * @author Zhiyong
 *
 */
public class SIN extends Command{
	public SIN(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		try{
		double degree = parameters.get(0);
		returnValue = Math.sin(degree);
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		return returnValue;
	}

}