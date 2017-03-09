package commands;

public class BACK extends TurtleCommand {
	
	public BACK() {
		super();
		expectedNumParameters = 1;
	}
	
	@Override
	public double executeCommand() {
	
		returnValue = parameters.get(0);
		ForwardBackHelper f = new ForwardBackHelper();
		f.getHelp(target, returnValue);
	
		return returnValue;
	}
	
}