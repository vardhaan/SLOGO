package commands;

/**
 * @author Zhiyong
 *
 */
public class PENDOWN extends TurtleCommand {
	
	public PENDOWN(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public double executeCommand() {
		penDown = true;
		returnValue = 1;
		return 1;
	}
	

}
