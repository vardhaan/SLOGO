/**
 * 
 */
package commands;

import exceptions.ParameterNotEnoughException;

/**
 * @author Zhiyong
 *
 */
public class TELL extends Command{
	
	public TELL(){
		super();
		//expectedNumParameters = Integer.MAX_VALUE;
	}
	
	@Override
	public void setReturnValue() throws ParameterNotEnoughException {
		//return the index of the last turtle in the tell list
			returnValue =  parameters.get(parameters.size()  - 1);

		sendReturnToDependent();
	}

	@Override
	public double executeCommand() {
		System.out.println(returnValue);
		return returnValue;
	}

}
