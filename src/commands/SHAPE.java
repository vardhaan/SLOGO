package commands;

import exceptions.ParameterNotEnoughException;
import turtles.Turtle;

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
		returnValue = target.get(target.size()-1).getImageIndex();
		sendReturnToDependent();
		
	}

	@Override
	public double executeCommand() {
		returnValue = target.get(target.size()-1).getImageIndex();
		return returnValue;
	}

}