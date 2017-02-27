/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class PI extends Command{
	public PI(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		returnValue = Math.PI;
		setReturnValue();
		
		return returnValue;
	}

}