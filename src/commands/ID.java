package commands;

import exceptions.ParameterNotEnoughException;

public class ID extends TurtleCommand{
	public ID(){
		super();
		expectedNumParameters = 0;
	}

	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//do nothing
	}

	@Override
	public double executeCommand() {
		for(int i = 0; i < turtles.size(); i++){
			if(turtles.get(i).getActivity()){
				return i;
				
			}
		}
		//if there is no turtle, just return the 0th turtle
		return 0;
	}

}
