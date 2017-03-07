/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;
import exceptions.PopUpException;
import turtles.Turtle;

/**
 * @author Zhiyong
 *
 */
public class HOME extends TurtleCommand{
	
	public HOME(){
		super();
		expectedNumParameters = 0;
	}
	
	@Override
	public double executeCommand() {
		try {

		double x = target.getX();
		double y = target.getY();
		//return the distance that the turtle needs to move
		returnValue = Math.sqrt(x*x + y*y);
		
		target.setX(0);
		target.setY(0);
		target.setHeading(0);
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		return 1;
	}

}
