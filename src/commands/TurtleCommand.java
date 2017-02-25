package commands;

import java.util.ArrayList;

import turtles.Turtle;
import turtles.TurtleHandler;

public abstract class TurtleCommand extends Command {
	
	protected ArrayList<Double> parameters;
	protected double returnValue;
	protected double expectedNumParameters;
	protected String turtleTarget;
	
	public TurtleCommand() {
		this.turtleTarget = TurtleHandler.DEFAULT_TURTLE;
		parameters = new ArrayList<Double>();

	}
	
	public Turtle getTurtle() {
		Turtle ret = TurtleHandler.getTurtle(turtleTarget);
		return ret;
	}
	
	public void setReturnValue() {
		// TODO Auto-generated method stub
		double returnVal = 0;
		if (parameters.size() == expectedNumParameters) {
			for (int i=0;i<parameters.size();i++) {
				returnVal = parameters.get(i);
			}
		} else {
			//TODO: SOME EXCEPTION
		}
		
	}
	
	public abstract double executeCommand();
	
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
	
	public double getNumParameters(){
		return expectedNumParameters;
	}
	
	
}
