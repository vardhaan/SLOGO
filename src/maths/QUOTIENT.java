/**
 * 
 */
package maths;

/**
 * @author Zhiyong
 *
 */
public class QUOTIENT extends Maths{
	public QUOTIENT(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		double x = parameters.remove(0);
		double y = parameters.remove(1);
		returnValue = (y==0)? 0 : x / y;
		setReturnValue();
		
		return returnValue;
	}

}