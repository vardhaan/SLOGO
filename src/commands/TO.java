package commands;

import java.util.HashMap;
import java.util.Map;

import turtles.Turtle;

public class TO extends ListContainingCommand {
	private String methodName;
	private HashMap<String, Integer> methodParametersMap;
	private HashMap<String, LIST> methodCommands;
	
	public TO() {
		super();
		expectedNumParameters = 0;
	}
	
	public void setMethodParamMap(Map<String, Integer> map) {
		methodParametersMap = (HashMap<String, Integer>) map;
	}
	
	public void setMethodCommands(Map<String, LIST> map) {
		methodCommands = (HashMap<String, LIST>) map;
	}
	
	
	
	
	public void setMethodName(String s) {
		methodName = s;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
	@Override
	public void setReturnValue() {
		
		listOfCommands.setReturnValue();
		returnValue = listOfCommands.getReturnValue();
		sendReturnToDependent();
	}
	
	@Override
	public void setTurtle(Turtle turtle) {
		inputs.setTurtle(turtle);
		
		listOfCommands.setTurtle(turtle);
	}
	
	public boolean addCommandWithin(Command toAdd) {
		return (inputs == null || listOfCommands == null || listOfCommands.needsCommand() || inputs.needsCommand());
	}
	
	
	@Override
	public boolean needsCommand() {
		if (inputs != null) {
			methodParametersMap.put(methodName, inputs.subCommands.size());

		}
		if (inputs == null || listOfCommands == null) {
			//System.out.println("should be triggering");
			return true;
		}
		if (parameters.size()+numCommandAsParam != expectedNumParameters || listOfCommands.needsCommand() || inputs.needsCommand()) {
			return true;
		}
		System.out.println(inputs.needsCommand() + " or " + listOfCommands.needsCommand());
		return (inputs.needsCommand() || listOfCommands.needsCommand());
	}
	
	@Override
	public boolean needsParameter() {
		if (parameters != null && listOfCommands != null && inputs!=null) {
			return (parameters.size() +numCommandAsParam != expectedNumParameters || listOfCommands.needsParameter() || inputs.needsParameter());

		}
		return true;
	}
	
	@Override 
	public void addParameter(Double d) {
		if (parameters.size() + numCommandAsParam != expectedNumParameters) {
			//System.out.println(this.getClass().getSimpleName() + " has " + (parameters.size()+numCommandAsParam) + " existing parameters and needs this many: " + expectedNumParameters);
			//System.out.println("Parameter is added in the right place " + d);
			parameters.add(d);
		} else {
			if (inputs.needsParameter()) {
				inputs.addParameter(d);
			} else {
				listOfCommands.addParameter(d);
			}
			
		}
	}
	
	@Override
	public void addCommand(Command toAdd) {
		toAdd.addVariableSet(variables.get(variables.size()-1));
		if (inputs == null) {
			if (toAdd instanceof LIST) {
				inputs  = (LIST) toAdd;
				
			} else {
				//TODO: throw new exception
				
			}
			return;
		} 
		if (inputs.needsCommand()) {
			////System.out.println("should not be funny");
			inputs.addCommand(toAdd);
			return;
		}
		if (listOfCommands == null) {
			////System.out.println("this was done");
			if (toAdd instanceof LIST) {
				////System.out.println("triggered");
				listOfCommands = (LIST) toAdd;
				methodCommands.put(methodName, listOfCommands) ;
			} else {
				//TODO: Throw new exception
			}
			return;
		}
		listOfCommands.addCommand(toAdd);
		
	}

	@Override
	public double executeCommand() {
		// TODO Auto-generated method stub
		return 0;
	}
	



}
