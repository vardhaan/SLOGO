/**
 * 
 */
package commands;

import java.util.Random;

/**
 * @author Zhiyong
 *
 */
public class SIN extends Command{
	public SIN(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		double degree = parameters.get(0);
		returnValue = Math.sin(degree);
		setReturnValue();
		
		return returnValue;
	}

}