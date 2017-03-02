/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
import exceptions.ParameterNotEnoughException;
import exceptions.PopUpException;
import turtles.Turtle;

public class HEADING extends TurtleCommand {
	
	public HEADING() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		try {
		Turtle target = getTurtle();
		returnValue = target.getHeading();
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		return returnValue;
	}
	
}