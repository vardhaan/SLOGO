/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;
/**
 * @author Zhiyong
 *
 */
public class CS extends TurtleCommand{
	
	public CS(){
		super();
		expectedNumParameters = 0;
	}
	
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
			returnValue = 0;
			sendReturnToDependent();
		}
	}
	
	@Override
	public double executeCommand() {
		double x = target.getX();
		double y = target.getY();
		//return the distance that the turtle needs to move
		returnValue = Math.sqrt(x*x + y*y);
		
		target.setX(0);
		target.setY(0);
		target.setHeading(0);
		target.clearLines();
		return returnValue;
	}

}
