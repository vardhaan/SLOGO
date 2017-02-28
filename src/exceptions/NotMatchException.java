/**
 * 
 */
package exceptions;

import java.util.ResourceBundle;

/**
 * @author Zhiyong
 *
 */
public class NotMatchException extends MyException{

	public static final String DEFAULT_RESOURCE_PACKAGE = "resources/exception";
	
	@Override
	public String getMessage() {
		ResourceBundle myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
		String message = myResources.getString("NotMatch");
		
		return message;
	}

}
