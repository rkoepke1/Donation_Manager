/**
 * Manages adding a new package to the container, a new volunteer to the volunteer queue line, 
 * a new recipient to the recipient queue and donating package by the volunteer to the recipient.
 * @author Ryan Koepke
 */
package dataManager;
import dataElements.DonationPackage;
import dataElements.Recipient;
import dataElements.Volunteer;
import dataStructure.Container;
import dataStructure.RecipientLine;
import dataStructure.VolunteerLine;
import exceptions.ContainerException;
import exceptions.RecipientException;
import exceptions.VolunteerException;
import interfaces.DonationManageInterface;

public class DonationManager implements DonationManageInterface{
	private final int CAPACITY = 5;
	private int donationCount = 0;
	private Container container = new Container(CAPACITY);
	private RecipientLine recipients = new RecipientLine(CAPACITY);
	private VolunteerLine volunteers = new VolunteerLine(CAPACITY);
	private DonationPackage pkg;
	private Volunteer vol;
	private Recipient rec;
	
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * @return true if the package is stacked, false if the container is full
	 * @throws ContainerException if container is full
	 */
	@Override
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		if(container.loadContainer(dPackage)) {
			return true;
		}else {
			return false;
		}
		
	}

	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		if(volunteers.addNewVolunteer(v)) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param r a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException("Recipient Line is full") if the Recipient line is full
	 */
	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		if(recipients.addNewRecipient(r)) {
			return true;
		}else {
			return false;
		}
		
	}
	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  volunteer line and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @throws VolunteerException("Volunteer Queue is empty") if there are no volunteers
	 * @throws ContainerExcpetion("Contain is empty") if the container is empty
	 * @throws RecipientException("Recipient Queue is empty") if there are no recipients
	 * @return Donation Count.
	 */
	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		
		pkg = container.removePackageFromContainer();
		vol = volunteers.volunteerTurn();
		volunteers.addNewVolunteer(vol);
		rec = recipients.recipientTurn();
		
		donationCount ++;
		return donationCount;
	}

	/**
	 * Returns an array of DonationPackages
	 * @return an array of Donation Packages
	 */
	@Override
	public DonationPackage[] managerArrayPackage() {
		return container.toArrayPackage();
	}

	/**
	 * Returns an array of Volunteers
	 * @return an array of Volunteers
	 */
	@Override
	public Volunteer[] managerArrayVolunteer() {
		return volunteers.toArrayVolunteer();
	}

	/**
	 * Returns an array of Recipients
	 * @return an array of Recipients
	 */
	@Override
	public Recipient[] managerArrayRecipient() {
		return recipients.toArrayRecipient();
	}
	
	/**
	 * returns a String of the name of the volunteer, the package contents and the name of who they delivered
	 * it to.
	 * @return Description string.
	 */
	public String toString() {
		return vol.getName() + " delivered " + pkg.getDescription() + " to " + rec.getName();
	}

}
