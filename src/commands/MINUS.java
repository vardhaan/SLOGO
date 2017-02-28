/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class MINUS extends Command{
	public MINUS(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		double x = parameters.get(0);
		returnValue = -x ;
		setReturnValue();
		
		return returnValue;
	}

}