/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;
import turtles.Turtle;
/**
 * @author Zhiyong
 *
 */
public class CS extends TurtleCommand{
	
	public CS(){
		super();
		expectedNumParameters = 0;
	}
	
	@Override
	public double executeCommand() {
		Turtle turtle = getTurtle();
		double x = turtle.getX();
		double y = turtle.getY();
		//return the distance that the turtle needs to move
		returnValue = Math.sqrt(x*x + y*y);
		
		turtle.setX(0);
		turtle.setY(0);
		turtle.setHeading(0);

		try {
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			e.getMessage();
		}
		return returnValue;
	}

}
