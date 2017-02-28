/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class TAN extends Command{
	public TAN(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		double degree = parameters.get(0);
		returnValue = (degree %  (Math.PI/2) == 0) ? 0 :Math.tan(degree);
		setReturnValue();
		
		return returnValue;
	}

}
