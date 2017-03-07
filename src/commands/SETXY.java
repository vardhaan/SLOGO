/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
import exceptions.ParameterNotEnoughException;
import exceptions.PopUpException;

public class SETXY extends TurtleCommand {

	public SETXY() {
		super();
		expectedNumParameters = 2;
	}

	@Override
	public double executeCommand() {
		try{
			double x = parameters.get(0);
			double y = parameters.get(1);
			//the degree  that turtle turned
			returnValue = Math.sqrt(x *x + y * y);
			target.setX(x);
			target.setY(y);
			setReturnValue();
			return returnValue;			
		} catch (ParameterNotEnoughException e) {
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		return 0;
	}

}