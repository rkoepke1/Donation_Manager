/**
 * Class that uses the queue data structure to store volunteers in a queue.
 * 
 * @author Ryan Koepke
 */
package dataStructure;
import dataElements.Volunteer;
import exceptions.VolunteerException;
import interfaces.VolunteerLineInterface;
public class VolunteerLine implements VolunteerLineInterface{
	
	MyQueue<Volunteer> volunteers;
	
	/**
	 * Constructor that initialized the volunteer line capacity to a specified value.
	 * @param size line capacity size.
	 */
	public VolunteerLine(int size) {
		volunteers = new MyQueue<>(size);
	}
	
	/**
	 * Default constructor set to the default capacity.
	 */
	public VolunteerLine() {
		volunteers = new MyQueue<>();
	}

	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Queue is full") is queue is full
	 */
	@Override
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		if(!volunteers.isFull()) {
			return volunteers.enqueue(v);
		}else {
			throw new VolunteerException("Volunteer Queue is full.");
		}
	}

	/**
	 * removes volunteer from the volunteer queue line
	 * @return Volunteer Object
	 * @throws VolunteerException("Volunteer queue is empty") if queue is empty
	 */
	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
		if(!volunteers.isEmpty()) {
			return volunteers.dequeue();
		}else {
			throw new VolunteerException("Volunteer Queue is empty.");
			
		}
	}

	/**
	 * checks if there are volunteers in line 
	 * @return true if volunteer line is empty, true otherwise
	 */
	@Override
	public boolean volunteerLineEmpty() {
		return volunteers.isEmpty();
	}

	/**
	 * Returns an array of the volunteers in the queue.  
	 * @return an array of the volunteers in the queue
	 */
	@Override
	public Volunteer[] toArrayVolunteer() {
		Volunteer[] volunteerArray = new Volunteer[volunteers.size()];
		Object[] stackArray = volunteers.toArray();
		for(int i = 0; i < volunteers.size(); i ++) {
			volunteerArray[i] = (Volunteer)stackArray[i];
		}	
		return volunteerArray;
	}
}

