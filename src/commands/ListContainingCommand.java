package commands;

import turtles.Turtle;

public abstract class ListContainingCommand extends Command{
	protected LIST listOfCommands;
	protected LIST inputs;
	
	//private ArrayList<Double> parameters;
	
	public ListContainingCommand(){
		super();
		listOfCommands = null;
		inputs = null;
	}
	
	@Override
	public void setTurtle(Turtle turtle) {
		inputs.setTurtle(turtle);
		
		listOfCommands.setTurtle(turtle);
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
		if (parameters.size()+numCommandAsParam != expectedNumParameters || listOfCommands.needsCommand() || inputs.needsCommand()) {
			return true;
		}
		return (inputs.needsCommand() || listOfCommands.needsCommand());
	}
	
	@Override
	public boolean needsParameter() {
		if (parameters != null && listOfCommands != null && inputs!=null) {
			return (parameters.size() +numCommandAsParam != expectedNumParameters || listOfCommands.needsParameter() || inputs.needsParameter());

		}
		return true;
	}
	
	@Override 
	public void addParameter(Double d) {
		if (parameters.size() + numCommandAsParam != expectedNumParameters) {
			parameters.add(d);
		} else {
			if (inputs.needsParameter()) {
				inputs.addParameter(d);
			} else {
				listOfCommands.addParameter(d);
			}
			
		}
	}
	
	@Override
	public void addCommand(Command toAdd) {
		if (inputs == null) {
			//System.out.println("should not be null");
			if (toAdd instanceof LIST) {
				inputs  = (LIST) toAdd;
				
			} else {
				//TODO: throw new exception
				
			}
			return;
		} 
		if (inputs.needsCommand()) {
			//System.out.println("should not be funny");
			inputs.addCommand(toAdd);
			return;
		}
		if (listOfCommands == null) {
			//System.out.println("this was done");
			if (toAdd instanceof LIST) {
				//System.out.println("triggered");
				listOfCommands = (LIST) toAdd;
			} else {
				//TODO: Throw new exception
			}
			return;
		}
		listOfCommands.addCommand(toAdd);
		
	}
	
}
