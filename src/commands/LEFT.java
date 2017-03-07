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

public class LEFT extends TurtleCommand {
	
	public LEFT() {
		super();
		expectedNumParameters = 1;
	}
	
	
	

	@Override
	public double executeCommand() {
		
		try {
			returnValue = parameters.get(0);
			setReturnValue();
			target.setHeading(target.getHeading() - returnValue);
			System.out.println(target.getHeading());
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}

		return returnValue;
	}
	
}