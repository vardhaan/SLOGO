/**
 * 
 */
package commands;

import java.util.Random;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class RANDOM extends Command{
	public RANDOM(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {

			Random random = new Random();
			
			returnValue = random.nextInt((int)parameters.get(parameters.size()-1).intValue()) * 1.0;

			sendReturnToDependent();
		}
	}

	@Override
	public double executeCommand() {
		double max = parameters.get(0);
		Random random = new Random((long) max);
		returnValue = random.nextDouble() ;	
		return returnValue;
	}

}