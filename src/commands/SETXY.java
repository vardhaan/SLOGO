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

public class SETXY extends TurtleCommand {
	
	public SETXY() {
		super();
		expectedNumParameters = 2;
	}
	
	@Override
	public double executeCommand() {
	try{
		double x = parameters.get(0);
		double y = parameters.get(1);
		//the degree  that turtle turned
		returnValue = Math.sqrt(x *x + y * y);
		
		Turtle target = getTurtle();
		target.setOverallXChange( x - target.getX());
		target.setOverallYChange(y - target.getY());
		setReturnValue();
		return returnValue;
		
			
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
	return 0;
	}
	
}