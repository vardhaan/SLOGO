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
	public boolean needsVariable() {
		return v==null;
	}
	
	
	@Override
	public double executeCommand() {
		// TODO Auto-generated method stub
		return returnValue;
	}

}
