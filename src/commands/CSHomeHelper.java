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
	/**
	 * this is the heler method for the CS and HOME
	 */
	public void getHelp(Turtle target){
		double x = target.getX();
		double y = target.getY();
		//return the distance that the turtle needs to move
		Double returnValue = Math.sqrt(x*x + y*y);
		
		target.setX(0);
		target.setY(0);
		target.setHeading(0);
	}

	/**
	 * set the return value
	 * 
	 */
	public Double getRetVal(Turtle target) {
		double x = target.getX();
		double y = target.getY();
		//return the distance that the turtle needs to move
		Double retVal = Math.sqrt(x*x + y*y);
		return retVal;
	}
	
}
