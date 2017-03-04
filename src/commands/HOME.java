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
		Turtle turtle = getTurtle();
		double x = turtle.getX();
		double y = turtle.getY();
		//return the distance that the turtle needs to move
		returnValue = Math.sqrt(x*x + y*y);
		
		turtle.setX(0);
		turtle.setY(0);
		turtle.setHeading(0);
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		return 1;
	}

}
