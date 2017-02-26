/**
 * 
 */
package maths;

/**
 * @author Zhiyong
 *
 */
public class COS extends Maths{
	public COS(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		double degree = parameters.remove(0);
		returnValue = Math.cos(degree);
		setReturnValue();
		
		return returnValue;
	}

}