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
public class PENUP extends TurtleCommand {

	public PENUP(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		try{
		penDown = false;
		returnValue = 0;
		target.setPenDown(false);
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		
		return 0;
	}
	
}
