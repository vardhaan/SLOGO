package commands;

public class MAKE extends Command {
	private String variableName;
	private VARIABLE v;
	public MAKE() {
		super();
		expectedNumParameters = 1;
	}
	
	public void setVariableName(String name) {
		variableName = name;
	}
	
	public String getVariableName() {
		return this.variableName;
	}
	
	@Override
	public boolean needsCommand() {
		return v == null || (parameters.size() +numCommandAsParam != expectedNumParameters);
	}
	
	
	public void addCommand(Command toAdd) {
		if (toAdd instanceof VARIABLE) {
			v = (VARIABLE) toAdd;
		} else {
			//TODO: THROW EXCEPTION
		}
	}
	
	@Override
	public void setReturnValue() {
		returnValue = parameters.get(0);
		for (int i=0;i<variables.size();i++) {
			if (variables.get(i).containsKey(v)) {
				variables.get(i).put(v.getName(), returnValue);
				return;
			}
		}
		
		variables.get(variables.size()-1).put(v.getName(), returnValue);
	}
	
	@Override
	public double executeCommand() {
		// TODO Auto-generated method stub
		return returnValue;
	}

}
