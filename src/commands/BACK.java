package commands;

import exceptions.ParameterNotEnoughException;
import exceptions.PopUpException;
import turtles.Turtle;

public class BACK extends TurtleCommand {
	
	public BACK() {
		super();
		expectedNumParameters = 1;
	}
	
	
	

	@Override
	public double executeCommand() {
	
		try{
		returnValue = parameters.get(0);
		double degree = target.getHeading();
		double y = Math.sin(degree*Math.PI/180) * returnValue;
		double x = Math.cos(degree*Math.PI/180) * returnValue;
		//System.out.println("starts");

		//System.out.println(target.getX());
		//System.out.println(target.getY());
		//System.out.println(target.getX() - x);
		//System.out.println(target.getY() - y);

		target.setX(target.getX() - x);
		target.setY(target.getY() - y);
		
			setReturnValue();
		}catch (ParameterNotEnoughException e) {
			
			PopUpException p = new PopUpException(e.getMessage());
			p.showMessage();
		}
		return returnValue;
	}
	
}