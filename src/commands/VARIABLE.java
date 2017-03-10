package commands;

import java.util.HashMap;

public class VARIABLE extends Command {
	private String variableName;
	
	public VARIABLE() {
		super();
	}
	
	public void setName(String name) {
		variableName = name;
	}
	
	public String getName() {
		return variableName;
	}
	
	public boolean needsParameter() {
		return false;
	}
	
	public boolean needsCommand() {
		return false;
	}
	
	protected Double getVariableValue() {
		Double mostRecentVal = 0.0;
		boolean varInMap = false;
		for (int i=0;i<variables.size();i++) {
			HashMap<String, Double> map = variables.get(i);
			if (map.containsKey(this.getName())) {
				mostRecentVal = map.get(this.getName());
				varInMap = true;
			}
		}
		if (varInMap) {
			return mostRecentVal;
		}
		variables.get(variables.size()-1).put(this.variableName, 0.0);
		return 0.0;
	}
	
	
	
	@Override
	public void setReturnValue() {
		returnValue = this.getVariableValue();
		//System.out.println(returnValue + " was the value gotten from the MAPS");
		sendReturnToDependent();
	}
	
	
	@Override
	public double executeCommand() {
		// TODO Auto-generated method stub
		return 0;
	}

}
