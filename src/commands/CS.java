/**
 * 
 */
package commands;

import java.lang.reflect.Method;

import turtles.Turtle;
/**
 * @author Zhiyong
 *
 */
public class CS extends TurtleCommand{
	
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
		//TODO: here need to get an object from the history and remove all the lines
		
		return returnValue;
	}

}
