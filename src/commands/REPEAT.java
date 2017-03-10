package commands;

public class REPEAT extends ListContainingCommand {

	
	public REPEAT() {
		super();
		expectedNumParameters = 1;
		inputs = new LIST();
		inputs.addCommand(new LISTEND());
		inputs.expectedNumCommands = (double) inputs.subCommands.size();
	}
	
	
	@Override
	public boolean addCommandWithin(Command toAdd) {
		if (numCommandAsParam + parameters.size()== expectedNumParameters) {
			//System.out.println("repeat actually gets a value");
			return listOfCommands == null || listOfCommands.needsCommand();
		}
		return false;
		
	}
	
	
	
	
	@Override
	public double executeCommand() {
		// TODO Auto-generated method stub
		Double d = 0.0;
		for (int i=0;i<parameters.get(0);i++) {
			d = listOfCommands.executeCommand();
		}
		return d;
	}

	
	
	

}
