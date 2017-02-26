/**
 * 
 */
package maths;

import java.util.Random;

/**
 * @author Zhiyong
 *
 */
public class RANDOM extends Maths{
	public RANDOM(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		double max = parameters.remove(0);
		Random random = new Random((long) max);
		returnValue = random.nextDouble() ;
		setReturnValue();
		
		return returnValue;
	}

}