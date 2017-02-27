/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class DIFFERENCE extends Command{
	public DIFFERENCE(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = x - y;
		setReturnValue();
		
		return returnValue;
	}

}
