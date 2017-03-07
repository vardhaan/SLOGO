package commands;

import java.util.ArrayList;
import java.util.List;

import exceptions.ParameterNotEnoughException;
import turtles.Turtle;

public abstract class Command {
	protected List<Double> parameters;
	protected double returnValue;
	protected double expectedNumParameters = 0;
	protected Command dependent;
	protected int numCommandAsParam;
	protected Turtle target;

	
	public Command() {
		parameters = new ArrayList<Double>();
		returnValue = 0;
	}
	
	public List<Double> getParameters() {
		return parameters;
	}
	
	public void setTurtle(Turtle turtle) {
		// TODO Auto-generated method stub
		target = turtle;
		
	}
	
	public boolean needsVariable() {
		return false;
	}
	
	public double getNumParameters() {
		//System.out.println("goes here");
		return expectedNumParameters;
		
	}
	
	public boolean needsParameter() {
		return !(parameters.size() + numCommandAsParam == expectedNumParameters);
	}
	
	public boolean needsCommand() {
		return needsParameter();
	}
	
	public void addCommand(Command toAdd) {
		toAdd.setDependent(this);
	}
	
	public double getReturnValue() {
		return returnValue;
	}
	
	public void addParameter(Double param) {
		//System.out.println("param ALSO ADDED HERE");
		this.parameters.add(param);
	}
	
	protected void sendReturnToDependent() {
		if (dependent != null) {
			System.out.println("This value is being added to param: " + returnValue);
			dependent.numCommandAsParam--;
			dependent.addParameter(returnValue);
			
			System.out.println("Dependent, " + dependent.getClass().getSimpleName() + ", now has " + dependent.parameters.size() + " " + numCommandAsParam + " because of " + this.getClass().getSimpleName());
		}
		
	}
	
	public void setDependent(Command dependent) {
		this.dependent = dependent;
		dependent.numCommandAsParam++;
		System.out.println("Dependent is set " + dependent.getClass().getName());
		System.out.println(dependent.numCommandAsParam + " is numComAsParam");
		//System.out.println("dependent now has: " + (dependent.numCommandAsParam+dependent.parameters.size()));
	}
	
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
				returnValue = (parameters.get(parameters.size()-1));
				
				sendReturnToDependent();
		} else {
			ParameterNotEnoughException p =  new ParameterNotEnoughException();
			//TODO: the frontend get the message of the exception
			p.getMessage();
		}
		
	}
	
	public abstract double executeCommand();
}
