package commands;

import java.util.ArrayList;

import turtles.Turtle;
import turtles.TurtleHandler;

public abstract class TurtleCommand extends Command {

	protected String turtleTarget;
	
	public TurtleCommand() {
		this.turtleTarget = TurtleHandler.DEFAULT_TURTLE;
		parameters = new ArrayList<Double>();

	}
	
	public Turtle getTurtle() {
		Turtle ret = TurtleHandler.getTurtle(turtleTarget);
		return ret;
	}
	
	
	
	public abstract double executeCommand();
	
	
	
	public void setTurtleX() {
		//TODO: IMPLEMENT
	}
	
	public void setTurtleY() {
		//TODO: IMPLEMENT
	}
	
	public void setDegree() {
		//TODO: IMPLEMENT
	}
	
	public double getNumParameters(){
		return expectedNumParameters;
	}
	
	
}
