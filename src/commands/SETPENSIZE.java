/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class SETPENSIZE extends Command {
	
	public SETPENSIZE(){
		super();
		expectedNumParameters = 1;
	}
	
	@Override
	public double executeCommand() {
			//ResourceBundle resources = ResourceBundle.getBundle(RESOURCE_BUNDLE);
			
			//TODO:add a method to set the pensize
			returnValue = parameters.get(0);
			
		return returnValue;
	}

}
