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

public class SETHEADING extends TurtleCommand {
	
	public SETHEADING() {
		super();
		expectedNumParameters = 1;
	}
	
	
	

	@Override
	public double executeCommand() {
	try{
		returnValue = parameters.get(0);
		
		
			setReturnValue();
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		
		Turtle target = getTurtle();
		double degree = target.getHeading();
		target.setOverallHeadingChange(degree);
		return returnValue;
	}
	
}