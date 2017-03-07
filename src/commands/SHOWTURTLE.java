/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class SHOWTURTLE extends TurtleCommand{

	public SHOWTURTLE(){
		super();
		expectedNumParameters = 0;
	}
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//DO NOTHING
	}

	@Override
	public double executeCommand() {
		showTurtle = true;
		returnValue = 1;
		target.setShow(true);

		return 1;
	}

}
