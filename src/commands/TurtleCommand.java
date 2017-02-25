package commands;

import java.util.ArrayList;

public abstract class TurtleCommand extends Command {
	
	protected ArrayList<Double> parameters;
	protected double returnValue;
	protected double expectedNumParameters;
	protected String turtleTarget;
	
	public void setReturnValue() {
		//TODO: IMPLEMENT
	}
	
	public double getReturnValue() {
		return returnValue;
	}
	
	public void setTurtleX() {
		//TODO: IMPLEMENT
	}
	
	public void setTurtleY() {
		//TODO: IMPLEMENT
	}
	
	public void setDegree() {
		//TODO: IMPLEMENT
	}
	
	
}
