/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class HOME extends TurtleCommand{
	
	public HOME(){
		super();
		expectedNumParameters = 0;
	}
	
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//DO NOTHING
	}
	
	@Override
	public double executeCommand() {
		CSHomeHelper c = new CSHomeHelper();
		c.getHelp(target, returnValue);
		
		return returnValue;
	}

}
