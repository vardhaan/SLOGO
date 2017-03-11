package commands;

import java.util.PriorityQueue;
import turtles.Turtle;

/**
 * @author Zhiyong
 *
 */
public class TELL extends ListContainingCommand{
	
	public TELL() {
		super();
		expectedNumParameters = 0;
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
		
		double d = 0.0;

		PriorityQueue<Integer> turtleID = new PriorityQueue<>();
		
		for(int i = 0; i < listOfCommands.subCommands.size(); i ++){
			d = Math.round(listOfCommands.subCommands.get(i).executeCommand());
			turtleID.add((int) d);
		}
		
		createTurtle(turtleID);
		actUpTurtle(turtleID);
		return d;
		
		
	}


	private void actUpTurtle(PriorityQueue<Integer> turtleID) {
		for(int id : turtleID){
			target.get(id).updateActivity(true);
		}
		
	}


	private void createTurtle(PriorityQueue<Integer> turtleID) {
		for(int i = 0; i < turtleID.size(); i++){
			if(target.size() <= i){
				//create a new turtle of id = i
				Turtle turtle = new Turtle(i, null);
				for(int j = 0; j < i -target.size() + 2; j++){
					//add some null turtles between the size and index i
					target.add(null);
				}
				target.add(turtle);
				
			}
		}
		
	}
}
