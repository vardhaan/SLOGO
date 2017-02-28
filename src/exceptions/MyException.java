/**
 * 
 */
package exceptions;

/**
 * @author Zhiyong
 *
 */
public abstract class MyException extends Exception {
	
	public MyException(){
		super();
	}
	public abstract String getMessage();

}
