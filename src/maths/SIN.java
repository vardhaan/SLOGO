/**
 * 
 */
package maths;

import java.util.Random;

/**
 * @author Zhiyong
 *
 */
public class SIN extends Maths{
	public SIN(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		double degree = parameters.remove(0);
		returnValue = Math.sin(degree);
		setReturnValue();
		
		return returnValue;
	}

}