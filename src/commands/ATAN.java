/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class ATAN extends Command{
	public ATAN(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		double degree = parameters.remove(0);
		returnValue = Math.atan(degree);
		setReturnValue();
		
		return returnValue;
	}

}