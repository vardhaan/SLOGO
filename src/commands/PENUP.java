/**
 * 
 */
package commands;

import turtles.Turtle;

/**
 * @author Zhiyong
 *
 */
public class PENUP extends TurtleCommand {

	public PENUP(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		penDown = false;
		returnValue = 0;
		Turtle turtle = getTurtle();
		turtle.setPenDown(false);
		
		return 0;
	}
	
}
