package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class SHAPE extends Command{

	public SHAPE(){
		super();
		expectedNumParameters = 0;

	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//do nothing
	}

	@Override
	public double executeCommand() {
		returnValue = target.getID();
		//System.out.println("The current shape is: " + returnValue);
		return returnValue;
	}

}