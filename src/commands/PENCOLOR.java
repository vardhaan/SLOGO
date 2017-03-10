package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class PENCOLOR extends Command{
	public PENCOLOR(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//do nothing
	}

	@Override
	public double executeCommand() {
		returnValue = target.getPenColorIndex();
		System.out.println("The pen color is " + returnValue);
		return returnValue;
	}

}