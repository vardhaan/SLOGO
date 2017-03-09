package commands;

public class FORWARD extends TurtleCommand {

	public FORWARD() {
		super();
		expectedNumParameters = 1;
	}
	

	@Override
	public double executeCommand() {
		
		returnValue = parameters.get(0);		
		ForwardBackHelper f = new ForwardBackHelper();
		f.getHelp(target, -returnValue);
		
		return returnValue;
	}


}