package commands;

import exceptions.ParameterNotEnoughException;
import exceptions.PopUpException;
import turtles.Turtle;

/**
 * @author Zhiyong
 *
 */
public class PENDOWN extends TurtleCommand {
	
	public PENDOWN(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		try{
		penDown = true;
		returnValue = 1;
		
		target.setPenDown(true);
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		
		return 1;
	}
	

}
