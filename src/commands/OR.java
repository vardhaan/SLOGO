/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class  OR extends Command{
	public OR(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = (x != 0 || y != 0)? 1 : 0;
		setReturnValue();
		
		return returnValue;
	}

}