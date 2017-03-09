package commands;

import java.util.ArrayList;

import turtles.Turtle;

public abstract class TurtleCommand extends Command {

	protected int turtleTarget;
	protected boolean penDown;
	protected boolean showTurtle;
	
	public TurtleCommand() {
		turtleTarget = 0;
		parameters = new ArrayList<Double>();
		penDown = true;
		showTurtle = true;
	}
	
	@Override
	public void setTurtle(Turtle turtle) {
		target = turtle;
	}
	
/*	public Turtle getTurtle() {
		Turtle ret = new Turtle();
		TurtleViewer.getTurtle(turtleTarget);
		return ret;
	} */
	
	
	public abstract double executeCommand();
	
	
	public void setTurtleX() {
		//TODO
	}
	
	public  void setTurtleY() {
		//TODO
	}
	
	public  void setDegree() {
		//TODO
	}
	
	public double getNumParameters(){
		return expectedNumParameters;
	}
	
}
