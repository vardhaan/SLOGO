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
		CSHomeHelper c = new CSHomeHelper();
		c.getHelp(target, returnValue);
		
		target.clearLines();
		return returnValue;
	}

}
