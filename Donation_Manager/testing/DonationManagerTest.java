package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataElements.DonationPackage;
import dataElements.Recipient;
import dataElements.Volunteer;
import dataManager.DonationManager;
import exceptions.ContainerException;
import exceptions.VolunteerException;
import exceptions.RecipientException;

 
/**
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
public class DonationManagerTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}
 
	@Test
	public void testManagerLoadcontainer()   {
	
		try {
			manager.managerLoadContainer(new DonationPackage("Pens",12));
			manager.managerLoadContainer(new DonationPackage("Books",12));
			manager.managerLoadContainer(new DonationPackage("NoteBooks",11));
			manager.managerLoadContainer(new DonationPackage("chairs",20));
			manager.managerLoadContainer(new DonationPackage("laptop",14));
			 
			 
		} catch (ContainerException e) {
			System.out.println("Should not throw exception ");
		}	 	 
	}
	 
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.managerQueueVolunteer(new  Volunteer("John"));
			manager.managerQueueVolunteer(new  Volunteer("Adam"));
			manager.managerQueueVolunteer(new  Volunteer("Nichole"));
			manager.managerQueueVolunteer(new  Volunteer("Allan"));
			manager.managerQueueVolunteer(new  Volunteer("Mary"));
			manager.managerQueueVolunteer(new  Volunteer("David"));
			
		} catch (VolunteerException e) {
			 
			System.out.println(e + "here");
		}
	 
	}

	/**
	 * Test method for  ManagerQueueRecipient, should be implemented by STUDENTS
	 */
	//@Test
	public void testManagerQueueRecipientSTUDENT() {
		 fail("testManagerQueueRecipientSTUDENT is not implemented");
	}

 
	@Test
	public void testDonatePackage() {
	    Volunteer v1;
	    Recipient r1, r2, r3, r4, r5;
	    DonationPackage d1,d2, d3, d4;
	    
	    v1 = new Volunteer("Monica"); 
		r1 =  new Recipient("MC College");
		r2 =  new Recipient("MC");
		r3 =  new Recipient("MC Cge");
		r5 =  new Recipient("MC Coge");
		
		
		d1 =  new DonationPackage("Pens",10);
		d2 =  new DonationPackage("Books",20);
		d3 =  new DonationPackage("Boks",20);
		d4 =  new DonationPackage("Boks",20);
		
		try {
			manager.managerLoadContainer(d1);
			manager.managerLoadContainer(d2);
			manager.managerQueueVolunteer(v1);    //add a volunteer
			manager.managerQueueRecipient(r1);   //Add a recipient
			manager.managerQueueRecipient(r1);   //Add a recipient
			
			
			
			assertEquals(manager.donatePackage(),1 );  // Donation successful
			
			assertEquals(manager.donatePackage(),2 );  // Can not donate package,There are no recipients in the queue
	
			manager.managerQueueRecipient(r1);   //Add a recipient
			
			assertEquals(manager.donatePackage(),2);    // donation process should be successful, this should remove the package from
			                                            // the container and recipients from the queue, Volunteer is enqueued again to the 
														// Volunteer line.
			
			assertEquals(manager.donatePackage(),2); //There is no recipient in the queue
			
		} catch (ContainerException | VolunteerException | RecipientException e) {
			 
			e.printStackTrace();
		}
	 
	} 

}
