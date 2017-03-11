/**
 * 
 */
package commands;

import turtles.Turtle;

public class RIGHT extends TurtleCommand {

	public RIGHT() {
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		returnValue = parameters.get(0);
		for (Turtle t : target) {
			t.setHeading(t.getHeading() + returnValue);
		}
		

		return returnValue;
	}

}