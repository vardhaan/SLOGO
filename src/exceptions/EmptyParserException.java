
package exceptions;

import java.util.ResourceBundle;

/**
 * @author Zhiyong
 *
 */
public class EmptyParserException extends MyException{
	 public static final String DEFAULT_RESOURCE_PACKAGE = "resources/exception";

	@Override
	public String getMessage() {
		ResourceBundle myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
		String message = myResources.getString("Empty");
		
		return message;
	}

}
