/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
import exceptions.ParameterNotEnoughException;

public class ISSHOWING extends TurtleCommand {
	
	public ISSHOWING() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//DO NOTHING
		returnValue = (target.get(target.size()-1).showTurtle() == true)? 1 : 0;
		sendReturnToDependent();
	}
	
	@Override
	public double executeCommand() {
		returnValue = (target.get(target.size()-1).showTurtle() == true)? 1 : 0;

		return returnValue;
	}
	
}