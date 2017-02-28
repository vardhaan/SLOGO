/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class AND extends Command{
	public AND(){
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		double y = parameters.get(1);
		returnValue = (x != 0 && y != 0)? 1 : 0;
		setReturnValue();
		
		return returnValue;
	}

}