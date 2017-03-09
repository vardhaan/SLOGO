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
			
			//TODO:add a method in the grid to set the background
			returnValue = parameters.get(0);
			
		return returnValue;
	}

}
