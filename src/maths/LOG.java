/**
 * 
 */
package maths;

/**
 * @author Zhiyong
 *
 */
public class LOG extends Maths{
	public LOG(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		double degree = parameters.remove(0);
		returnValue =(degree == 0)? 0 : Math.log(degree);
		setReturnValue();
		
		return returnValue;
	}

}