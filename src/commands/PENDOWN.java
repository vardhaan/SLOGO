package commands;

import exceptions.ParameterNotEnoughException;
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
		penDown = true;
		returnValue = 1;
		
		Turtle turtle = getTurtle();
		turtle.setPenDown(true);
		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			
			e.getMessage();
		}
		
		return 1;
	}
	

}
