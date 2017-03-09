/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class SETPALETTE extends Command {
	
	public SETPALETTE(){
		super();
		expectedNumParameters = 1;
	}
	
	@Override
	public double executeCommand() {
			//ResourceBundle resources = ResourceBundle.getBundle(RESOURCE_BUNDLE);
			
			//TODO:add a method to set the palette
			returnValue = parameters.get(0);
			
		return returnValue;
	}

}
