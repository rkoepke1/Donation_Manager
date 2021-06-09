/**
 * Recipient line exception class if queue is empty or full.
 * 
 * @author Ryan Koepke
 */
package exceptions;

public class RecipientException extends Exception{
	public RecipientException(String message) {
		super(message);
	}
}
