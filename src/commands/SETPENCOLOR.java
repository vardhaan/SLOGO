/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class SETPENCOLOR extends Command {
	
	public SETPENCOLOR(){
		super();
		expectedNumParameters = 1;
	}
	
	@Override
	public double executeCommand() {
			//ResourceBundle resources = ResourceBundle.getBundle(RESOURCE_BUNDLE);
			
			//TODO:add a method to set the pencolor
			returnValue = parameters.get(0);
			
		return returnValue;
	}

}
