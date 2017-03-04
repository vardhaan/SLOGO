package commands;

public abstract class ListContainingCommand extends Command{
	private LIST listOfCommands;
	private LIST inputs;
	
	//private ArrayList<Double> parameters;
	
	public ListContainingCommand(){
		super();
		listOfCommands = null;
		inputs = null;
	}
	
	public boolean addCommandWithin() {
		
		return (inputs == null || listOfCommands == null || listOfCommands.needsCommand() || inputs.needsCommand());
	}
	
	public void incrementNumCommAsParam() {
		numCommandAsParam++;
	}
	
	@Override
	public boolean needsCommand() {
		if (inputs == null || listOfCommands == null) {
			return true;
		}
		if (parameters.size()+numCommandAsParam != expectedNumParameters) {
			return true;
		}
		return (inputs.needsCommand() || listOfCommands.needsCommand());
	}
	
	@Override
	public boolean needsParameter() {
		return (parameters.size()!= expectedNumParameters || listOfCommands.needsParameter());
	}
	
	@Override 
	public void addParameter(Double d) {
		if (parameters.size() + numCommandAsParam != expectedNumParameters) {
			parameters.add(d);
		} else {
			listOfCommands.addParameter(d);
		}
	}
	
	@Override
	public void addCommand(Command toAdd) {
		if (toAdd instanceof LIST) {
			if (inputs == null) {
				inputs = (LIST) toAdd;
			} else {
				if (listOfCommands == null) {
					listOfCommands = (LIST) toAdd;
				} else {
					listOfCommands.addCommand(toAdd);
				}
			}
		}
		if (toAdd instanceof LISTEND) {
			if (inputs.needsCommand()) {
				inputs.addCommand(toAdd);
			} else {
				listOfCommands.addCommand(toAdd);
			}
		}
	}
	
}
