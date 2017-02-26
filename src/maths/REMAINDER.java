/**
 * 
 */
package maths;

/**
 * @author Zhiyong
 *
 */
public class REMAINDER extends Maths{
	public REMAINDER(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		double x = parameters.remove(0);
		double y = parameters.remove(1);
		returnValue = x % y;
		setReturnValue();
		
		return returnValue;
	}

}