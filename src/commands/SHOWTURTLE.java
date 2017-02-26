/**
 * 
 */
package commands;

import turtles.Turtle;

/**
 * @author Zhiyong
 *
 */
public class SHOWTURTLE extends TurtleCommand{
	
	public SHOWTURTLE(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		showTurtle = true;
		returnValue = 1;
		Turtle turtle = getTurtle();
		turtle.setShow(true);
		
		return 1;
	}

}
