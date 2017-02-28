package commands;

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
	
	public void manualSetReturn(double ret) {
		this.returnValue = ret;
		if (dependent!=null) {
			sendReturnToDependent();
		}
	}
	
	@Override
	public void setReturnValue() {
		this.returnValue = 0.0;
		
	}
	
	
	@Override
	public double executeCommand() {
		// TODO Auto-generated method stub
		return 0;
	}

}
