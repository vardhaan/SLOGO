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
		for(int index: turtles.keySet()){
			if(turtles.get(index).getActivity()){
				return index;
			}
		}
		return 0;
	}

}
