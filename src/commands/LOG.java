/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class LOG extends Command{
	public LOG(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		double degree = parameters.get(0);
		returnValue =(degree == 0)? 0 : Math.log(degree);
		setReturnValue();
		
		return returnValue;
	}

}