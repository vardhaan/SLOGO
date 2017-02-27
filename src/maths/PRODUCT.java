/**
 * 
 */
package maths;

/**
 * @author Zhiyong
 *
 */
public class PRODUCT extends Maths{
	public PRODUCT(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = x * y;
		setReturnValue();
		
		return returnValue;
	}

}