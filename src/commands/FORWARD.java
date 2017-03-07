package commands;

import exceptions.ParameterNotEnoughException;
import exceptions.PopUpException;
import turtles.Turtle;

public class FORWARD extends TurtleCommand {



	public FORWARD() {
		super();
		expectedNumParameters = 1;
	}
	

	@Override
	public double executeCommand() {

		try {
			returnValue = parameters.get(0);

			//System.out.println("The value is" + returnValue);
			double degree = target.getHeading();
			System.out.println(degree);
			double y = Math.sin(degree*Math.PI/180) * returnValue;
			double x = Math.cos(degree*Math.PI/180) * returnValue;
			target.setY(target.getY() + y);

			target.setX(target.getX() + x);
			setReturnValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//PopUpException pop = new PopUpException(e.getMessage());
			//pop.showMessage();
		}
		return returnValue;
	}


}