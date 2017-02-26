/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class PENUP extends TurtleCommand {

	public PENUP(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		penDown = false;
		returnValue = 0;
		
		return 0;
	}
	
}
