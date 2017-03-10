/**
 * 
 */
package exceptions;

import java.util.ResourceBundle;

/**
 * @author Zhiyong
 *
 */
public class ParameterNotEnoughException extends MyException{
	 public static final String DEFAULT_RESOURCE_PACKAGE = "resources/exception";
	 public static final String MESSAGE = "ParameterNotEnoughException";

	@Override
	public String getMessage() {
		ResourceBundle myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
		String message = myResources.getString(MESSAGE);
		
		return message;
	}

}
