package commands;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
	protected ArrayList<Double> parameters;
	protected double returnValue;
	protected double expectedNumParameters;
	protected Command dependent;

	
	public List<Double> getParameters() {
		return parameters;
	}
	
	public double getNumParameters() {
		return expectedNumParameters;
		
	}
	
	public double getReturnValue() {
		return returnValue;
	}
	
	public void addParameter(Double param) {
		this.parameters.add(param);
	}
	
	protected void sendReturnToDependent() {
		dependent.addParameter(returnValue);
	}
	
	public void setDependent(Command dependent) {
		this.dependent = dependent;
	}
	
	public void setReturnValue() {
		// TODO Auto-generated method stub
		if (parameters.size() == expectedNumParameters) {
			for (int i=0;i<parameters.size();i++) {
				returnValue = parameters.get(i);
			}
			if (dependent!=null) {
				sendReturnToDependent();

			}
		} else {
			//TODO: SOME EXCEPTION
		}
		
	}
	
	public abstract double executeCommand();
}
