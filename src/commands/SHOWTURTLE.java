/**
 * 
 */
package commands;

/**
 * @author Zhiyong
 *
 */
public class SHOWTURTLE extends TurtleCommand{
	
	public SHOWTURTLE(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		showTurtle = true;
		returnValue = 1;
		
		return 1;
	}

}
