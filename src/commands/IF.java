package commands;

public class IF extends ListContainingCommand {

	public IF() {
		super();
		expectedNumParameters = 1;
		inputs = new LIST();
		inputs.addCommand(new LISTEND());
		inputs.expectedNumCommands = (double) inputs.subCommands.size();
	}
	
	
	@Override
	public boolean addCommandWithin() {
		if (numCommandAsParam + parameters.size()== expectedNumParameters) {
			System.out.println("repeat actually gets a value");
			return listOfCommands == null || listOfCommands.needsCommand();
		}
		return false;
	}
	
	
	@Override
	public double executeCommand() {
		returnValue = 0;
		if (parameters.get(parameters.size()-1) != 0) {
			returnValue = listOfCommands.executeCommand();
		}
		return returnValue;
	}

}
