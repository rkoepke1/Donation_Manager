/**
 * Class that describes the volunteer.
 * 
 * @author Ryan Koepke
 */
package dataElements;

public class Volunteer {
	private String name;
	
	/**
	 * Constructor to set the name of the volunteer.
	 * @param name Name of the volunteer.
	 */
	public Volunteer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
	
}
