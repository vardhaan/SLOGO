/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
import exceptions.ParameterNotEnoughException;

public class ISPENDOWN extends TurtleCommand {
	
	public ISPENDOWN() {
		super();
		expectedNumParameters = 0;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//DO NOTHING
		returnValue = (target.get(target.size()-1).getPen() == true)? 1 : 0;
		sendReturnToDependent();
	}
	
	@Override
	public double executeCommand() {
		returnValue = (target.get(target.size()-1).getPen() == true)? 1 : 0;
		return returnValue;
	}
	
}