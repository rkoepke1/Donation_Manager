/**
 * Class that uses the queue data structure to store recipients in a queue.
 * 
 * @author Ryan Koepke
 */
package dataStructure;
import dataElements.Recipient;
import exceptions.RecipientException;
import interfaces.RecipientLineInterface;

public class RecipientLine implements RecipientLineInterface{
	MyQueue<Recipient> recipients;
	
	/**
	 * Constructor that initialized the recipient line capacity to a specified value.
	 * @param size line capacity size.
	 */
	public RecipientLine(int size) {
		recipients = new MyQueue<>(size);
	}
	
	/**
	 * Default constructor set to the default capacity.
	 */
	public RecipientLine() {
		recipients = new MyQueue<>();
	}
	
	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully
	 * @throws RecipientException("The Recipent Queue is Full") if queue is full
	 */
	@Override
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		if(!recipients.isFull()) {
			return recipients.enqueue(rc);
		}else {
			throw new RecipientException("Recipient Queu is full.");
		}
	}

	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throws RecipientException("The Recipient Queue is empty") if there is no Recipient in the line
	 */
	@Override
	public Recipient recipientTurn() throws RecipientException {
		if(!recipients.isEmpty()) {
			return recipients.dequeue();
		}else {
			throw new RecipientException("Recipient Queue is empty.");
		}
	}

	/**
	 * check if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	@Override
	public boolean recipientLineEmpty() {
		return recipients.isEmpty();
	}

	/**
	 * Returns an array of the Recipients in the queue.  
	 * @return an array of the Recipients in the queue
	 */
	@Override
	public Recipient[] toArrayRecipient() {
		Recipient[] recipientArray = new Recipient[recipients.size()];
		Object[] stackArray = recipients.toArray();
		for(int i = 0; i < recipients.size(); i ++) {
			recipientArray[i] = (Recipient)stackArray[i];
		}	
		return recipientArray;
	}

}
