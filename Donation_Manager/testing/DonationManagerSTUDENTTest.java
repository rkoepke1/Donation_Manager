package testing;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataElements.DonationPackage;
import dataElements.Recipient;
import dataElements.Volunteer;
import dataManager.DonationManager;
import exceptions.ContainerException;
import exceptions.RecipientException;
import exceptions.VolunteerException;

 
/**
 * @author Ryan koepke
 *
 */
public class DonationManagerSTUDENTTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}
 
	/** 
	 * Student test that a new DonationPackage is created and 
	 * the manager correctly calls load the container 
	 */
	@Test
	public void testManagerLoadcontainer()   {
		try {
			manager.managerLoadContainer(new DonationPackage("Concrete",5));
			manager.managerLoadContainer(new DonationPackage("Wood",3));
			manager.managerLoadContainer(new DonationPackage("Nails",11));
			manager.managerLoadContainer(new DonationPackage("Roofing",20));
			manager.managerLoadContainer(new DonationPackage("Rebar",14));
			 
		} catch (ContainerException e) {
			System.out.println("Should not throw exception ");
		}	 	 
	}
	 
	/**
	 * Student test that a new Volunteer is created and 
	 * the manager correctly queues the volunteer
	 */
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.managerQueueVolunteer(new  Volunteer("John"));
			manager.managerQueueVolunteer(new  Volunteer("Kathy"));
			manager.managerQueueVolunteer(new  Volunteer("Pete"));
			manager.managerQueueVolunteer(new  Volunteer("George"));
			manager.managerQueueVolunteer(new  Volunteer("Allen"));
			manager.managerQueueVolunteer(new  Volunteer("Jim"));
			
		} catch (VolunteerException e) {
			System.out.println(e + "here");
		}
	}

	/**
	 * Student test that a new Recipient is created and 
	 * the manager correctly queues the recipient
	 */
	@Test
	public void testManagerQueueRecipient() {
		try {
			manager.managerQueueRecipient(new  Recipient("Allen"));
			manager.managerQueueRecipient(new  Recipient("Lilah"));
			manager.managerQueueRecipient(new  Recipient("Harrison"));
			manager.managerQueueRecipient(new  Recipient("Dan"));
			manager.managerQueueRecipient(new  Recipient("Matt"));
			manager.managerQueueRecipient(new  Recipient("Jeff"));
		} catch (RecipientException e) {
			System.out.println(e + "here");
		}
	}

	/**
	 * Student test that the manager correctly calls donatePackage,
	 * testing the situations noted in the assignment document
	 */
	@Test
	public void testDonatePackage() {
		 	Volunteer v1, v2, v3, v4;
		    Recipient r1, r2, r3, r4, r5;
		    DonationPackage d1,d2, d3, d4;
		    
		    v1 = new Volunteer("Manson"); 
		    v1 = new Volunteer("Mason"); 
		    v1 = new Volunteer("McKensie"); 
		    v1 = new Volunteer("Chloe"); 
		    v1 = new Volunteer("Kaleb"); 
		    
			r1 =  new Recipient("Recip1");
			r2 =  new Recipient("Recip2");
			r3 =  new Recipient("Recip3");
			r5 =  new Recipient("Recip4");
			
			
			d1 =  new DonationPackage("pkg1",10);
			d2 =  new DonationPackage("pkg2",20);
			d3 =  new DonationPackage("pkg3",20);
			d4 =  new DonationPackage("pkg4",20);
			
			try {
				manager.managerLoadContainer(d1);
				manager.managerLoadContainer(d2);
				
				assertEquals(manager.donatePackage(),1 );  //Can not donate package, There are no volunteers in the queue
				
				manager.managerQueueVolunteer(v1);    //add a volunteer
				assertEquals(manager.donatePackage(),2 );  // Still Can not donate package,There are no recipients in the queue
				
				manager.managerQueueRecipient(r1);   //Add a recipient
				assertEquals(manager.donatePackage(),0);    // donation process should be successful, this should remove the package from
				                                            // the container and recipients from the queue, Volunteer is enqueued again to the 
															// Volunteer line.
				
				assertEquals(manager.donatePackage(),2); //There is no recipient in the queue
				
			} catch (ContainerException | VolunteerException | RecipientException e) {
				 
				e.printStackTrace();
			} 
	} 

}
