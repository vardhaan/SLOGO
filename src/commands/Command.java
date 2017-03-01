package commands;

import java.util.ArrayList;
import java.util.List;

import exceptions.ParameterNotEnoughException;

public abstract class Command {
	protected List<Double> parameters;
	protected double returnValue;
	protected double expectedNumParameters;
	protected Command dependent;
	protected int numCommandAsParam;

	
	public Command() {
		parameters = new ArrayList<Double>();
		returnValue = 0;
	}
	
	public List<Double> getParameters() {
		return parameters;
	}
	
	
	
	public double getNumParameters() {
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
		this.parameters.add(param);
	}
	
	protected void sendReturnToDependent() {
		if (dependent != null) {
			dependent.addParameter(returnValue);
			dependent.numCommandAsParam--;
		}
		
	}
	
	public void setDependent(Command dependent) {
		this.dependent = dependent;
		dependent.numCommandAsParam++;
		System.out.println("dependent now has: " + (dependent.numCommandAsParam+dependent.parameters.size()));
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
