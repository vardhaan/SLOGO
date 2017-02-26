/**
 * 
 */
package maths;

/**
 * @author Zhiyong
 *
 */
public class POW extends Maths{
	public POW(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		double x = parameters.remove(0);
		double y = parameters.remove(1);
		returnValue = Math.pow(x, y);
		setReturnValue();
		
		return returnValue;
	}

}