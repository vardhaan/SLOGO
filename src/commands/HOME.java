/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;
import turtles.Turtle;

/**
 * @author Zhiyong
 *
 */
public class HOME extends TurtleCommand{
	
	public HOME(){
		super();
		expectedNumParameters = 0;
	}
	
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//DO NOTHING
		returnValue = new CSHomeHelper().getRetVal(target.get(target.size()-1));
		sendReturnToDependent();
	}
	
	@Override
	public double executeCommand() {
		CSHomeHelper c = new CSHomeHelper();
		for (Turtle t : target) {
			c.getHelp(t);
		}
		
		return returnValue;
	}

}
