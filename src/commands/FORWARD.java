package commands;

public class FORWARD extends TurtleCommand {



	public FORWARD() {
		super();
		expectedNumParameters = 1;
	}
	

	@Override
	public double executeCommand() {
		
		returnValue = parameters.get(0);
		
		double degree = target.getHeading();
		double y = Math.sin(degree*Math.PI/180) * returnValue;
		double x = Math.cos(degree*Math.PI/180) * returnValue;
		target.setY(target.getY() + y);		
		target.setX(target.getX() + x);
		//target.setHeading(target.getHeading());
	
		return returnValue;
	}


}