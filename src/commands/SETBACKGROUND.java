/**
 * 
 */
package commands;

import gui.GridBuilder;

/**
 * @author Zhiyong
 *
 */
public class SETBACKGROUND extends Command{
	public SETBACKGROUND(){
		super();
		expectedNumParameters = 1;
	}

	@Override
	public double executeCommand() {
		GridBuilder grid = new GridBuilder();
		//TODO:add a method in the grid to set the background
		returnValue = parameters.get(0);
		grid.setBackgroundColor(returnValue);
		return 0;
	}

}
