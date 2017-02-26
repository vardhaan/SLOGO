/**
 * 
 */
package maths;

/**
 * @author Zhiyong
 *
 */
public class MINUS extends Maths{
	public MINUS(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		double x = parameters.remove(0);
		returnValue = -x ;
		setReturnValue();
		
		return returnValue;
	}

}