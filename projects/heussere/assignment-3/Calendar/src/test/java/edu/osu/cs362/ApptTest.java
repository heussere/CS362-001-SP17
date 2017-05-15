package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
	 
	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=30;
		 int startMinute=600;
		 int startDay=10;
		 int startMonth=40;
		 int startYear=0;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertFalse(appt.getValid());
		 	
	 }
	
	@Test
	public void test03() throws Throwable {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());    
		 
		 
		 appt.setStartHour(1000);
		 assertEquals(1000, appt.getStartHour());
		 assertFalse(appt.getValid());
		 appt.setStartHour(13);
		 
		  appt.setStartMinute(1000);
		 assertEquals(1000, appt.getStartMinute());
		 assertFalse(appt.getValid());
		 appt.setStartMinute(30);
		 
		 appt.setStartYear(-1);
		 assertEquals(-1, appt.getStartYear());
		 assertTrue(appt.getValid());
		 appt.setStartYear(2017);
		 
		  appt.setStartDay(1000);
		 assertEquals(1000, appt.getStartDay());
		 assertFalse(appt.getValid());
		 appt.setStartDay(10);
		 
		  appt.setStartMonth(1000);
		 assertEquals(1000, appt.getStartMonth());
		 assertFalse(appt.getValid());
		 appt.setStartMonth(4);
			
	}

	@Test
	public void test04() throws Throwable {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title=null;
		 String description=null;
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		assertEquals("", appt.getDescription());
		assertEquals("", appt.getTitle());
		assertTrue(appt.getValid());
		
	}
	
	@Test
	public void test05() throws Throwable {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=40;
		 int startYear=2017;
		 String title="Test";
		 String description="A test appointment";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		assertFalse(appt.getValid());
		assertEquals(null, appt.toString());
		
	}
	
	@Test
	public void test06() throws Throwable {
		 int startHour=0;
		 int startMinute=0;
		 int startDay=1;
		 int startMonth=1;
		 int startYear=2017;
		 String title="Test";
		 String description="A test appointment";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		assertTrue(appt.getValid());
		
		 startHour=23;
		 startMinute=59;
		 startDay=31;
		 startMonth=12;
		 startYear=2017;
		 title="Test";
		 description="A test appointment";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		assertTrue(appt2.getValid());
				
	}
	
	@Test
	public void test07() throws Throwable {
		int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Test";
		 String description="A test appointment";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		assertTrue(appt.getValid());
		
	}
	
	@Test
	public void test08() throws Throwable {
		int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=0;
		 int startYear=2017;
		 String title="Test";
		 String description="A test appointment";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		assertFalse(appt.getValid());
		
	}
	
	@Test
	public void test09() throws Throwable {
		int startHour=13;
		 int startMinute=30;
		 int startDay=0;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Test";
		 String description="A test appointment";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		assertFalse(appt.getValid());
		
	}
	
	@Test
	public void test10() throws Throwable {
		int startHour=13;
		 int startMinute=-10;
		 int startDay=10;
		 int startMonth=4;
		 
		 int startYear=2017;
		 String title="Test";
		 String description="A test appointment";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		appt.setStartYear(3);
		assertFalse(appt.getValid());
		
	}
	@Test
	  public void test11()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 String output = appt.toString();
		 //System.out.println(output);
		 assertEquals("\t4/10/2017 at 1:30pm ,Birthday Party, This is my birthday party.\n", output);         		
	 }
	 @Test
	  public void test12()  throws Throwable  {
		 int startHour=11;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 String output = appt.toString();
		 //System.out.println(output);
		 assertEquals("\t4/10/2017 at 11:30am ,Birthday Party, This is my birthday party.\n", output);         		
	 }
	
}
