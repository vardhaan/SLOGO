/**
 * 
 */
package commands;

import turtles.Turtle;

/**
 * @author Zhiyong
 *
 */
public class CSHomeHelper {
	public void getHelp(Turtle target, double returnValue){
		double x = target.getX();
		double y = target.getY();
		//return the distance that the turtle needs to move
		returnValue = Math.sqrt(x*x + y*y);
		
		target.setX(0);
		target.setY(0);
		target.setHeading(0);
	}

}
