/**
 * Volunteer line exception class if queue is empty or full.
 * 
 * @author Ryan Koepke
 */
package exceptions;

public class VolunteerException extends Exception{
	public VolunteerException(String message) {
		super(message);
	}
}
