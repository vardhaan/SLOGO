/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class COS extends Command{
	public COS(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		double degree = parameters.get(0);
		returnValue = Math.cos(degree);
		setReturnValue();
		
		return returnValue;
	}

}