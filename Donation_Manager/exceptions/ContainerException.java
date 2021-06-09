/**
 * Container exception class if stack is empty or full.
 * 
 * @author Ryan Koepke
 */
package exceptions;

public class ContainerException extends Exception {
	public ContainerException(String message) {
		super(message);
	}

}
