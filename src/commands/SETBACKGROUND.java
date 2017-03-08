/**
 * 
 */
package commands;

import java.util.ResourceBundle;

import gui.GridBuilder;

/**
 * @author Zhiyong
 *
 */
public class SETBACKGROUND extends Command{
	
	public static final String RESOURCE_BUNDLE = "index/backgroundcolor";
	
	public SETBACKGROUND(){
		super();
		expectedNumParameters = 1;
		
	}

	@Override
	public double executeCommand() {
		ResourceBundle resources = ResourceBundle.getBundle(RESOURCE_BUNDLE);
		GridBuilder grid = new GridBuilder();
		//TODO:add a method in the grid to set the background
		returnValue = parameters.get(0);
		//set the color of the grid to be the color at index = returnValue
		grid.setBackgroundColor(resources.getString(returnValue+""));
		return returnValue;
	}

}
