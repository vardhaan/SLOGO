/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class EQUAL extends Command{
	public EQUAL(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = (x == y)? 1 : 0;
		setReturnValue();
		
		return returnValue;
	}

}