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

	
	public void setReturnValue(){
		try{
		double x = parameters.get(0);
		double y = parameters.get(1);
		//parameters.add(1, x + y);
		returnValue = x + y;
		}catch(Exception e){
			PopUpException pop = new PopUpException(e.getMessage());
			pop.showMessage();
		}
	}
	
	@Override
	public double executeCommand() {
		setReturnValue();
		System.out.println("The value is " + returnValue);
		return returnValue;
	}

}
