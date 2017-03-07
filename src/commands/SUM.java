/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;
import exceptions.PopUpException;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Zhiyong
 *
 */
public class SUM extends Command{
	public SUM(){
		super();
		expectedNumParameters = 2;
	}
	
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
				returnValue = (parameters.get(0) + parameters.get(1));
				
				sendReturnToDependent();
		} else {
			ParameterNotEnoughException p =  new ParameterNotEnoughException();
			//TODO: the frontend get the message of the exception
			p.getMessage();
		}
		
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		//parameters.add(1, x + y);
		returnValue = x + y;
		System.out.println(returnValue);
		
		return returnValue;
	}

}