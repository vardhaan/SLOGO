/**
 * 
 */
package maths;

/**
 * @author Zhiyong
 *
 */
public class TAN extends Maths{
	public TAN(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		double degree = parameters.remove(0);
		returnValue = Math.tan(degree);
		setReturnValue();
		
		return returnValue;
	}

}
