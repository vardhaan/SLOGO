/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class LESS extends Command{
	public LESS(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = (x < y)? 1 : 0;
		setReturnValue();
		
		return returnValue;
	}

}
