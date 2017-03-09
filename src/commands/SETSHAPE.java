/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class SETSHAPE extends Command {
	
	public SETSHAPE(){
		super();
		expectedNumParameters = 1;
	}
	
	@Override
	public double executeCommand() {
			//ResourceBundle resources = ResourceBundle.getBundle(RESOURCE_BUNDLE);
			
			//TODO:add a method to set the shape of the turtle
			returnValue = parameters.get(0);
			
		return returnValue;
	}

}
