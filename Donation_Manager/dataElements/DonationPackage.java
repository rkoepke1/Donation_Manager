/**
 * Class that describes the donation package.
 * 
 * @author Ryan Koepke
 */
package dataElements;

public class DonationPackage {
	private String description;
	private double weight;
	
	/**
	 * Constructor to set the description and weight.
	 * @param description Provides the contents of the package.
	 * @param weight The weight of the package.
	 */
	public DonationPackage(String description, double weight) {
		this.description = description;
		this.weight = weight;
	}
	
	/**
	 * Checks if the package is too heavy or not.
	 * @return Returns true if too heave and false if its not.
	 */
	public boolean isHeavy() {
		if(weight > 20) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String toString() {
		return description;
	}

	
}
