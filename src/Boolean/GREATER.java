/**
 * 
 */
package Boolean;

/**
 * @author Zhiyong
 *
 */
public class GREATER extends Boolean{
	public GREATER(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = (x > y)? 1 : 0;
		setReturnValue();
		
		return returnValue;
	}

}