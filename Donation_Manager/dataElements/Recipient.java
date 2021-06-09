/**
 * Class that describes the recipient.
 * 
 * @author Ryan Koepke
 */
package dataElements;

public class Recipient {
	private String name;
	
	/**
	 * Constructor to set the name of the recipient.
	 * @param name Name of the recipient.
	 */
	public Recipient(String name) {
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
