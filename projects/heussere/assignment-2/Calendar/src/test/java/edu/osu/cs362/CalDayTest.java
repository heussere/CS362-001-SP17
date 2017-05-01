package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.LinkedList;
import java.util.GregorianCalendar;
import java.util.*;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
	
	

	 @Test
	  public void test01()  throws Throwable  {
		CalDay cal = new CalDay();
		assertFalse(cal.isValid());
		Iterator<?> testIterator = cal.iterator();
		assertEquals(testIterator, null);
		
		StringBuilder sb = new StringBuilder();
		String empty = sb.toString();
		assertEquals(empty,cal.toString());
	 }
	 @Test
	  public void test02()  throws Throwable  {
		
		GregorianCalendar gregcal = new GregorianCalendar();
		CalDay cal = new CalDay(gregcal);
		assertTrue(cal.isValid());
	 }
	 
	 
	 @Test
	  public void test03()  throws Throwable  {
		GregorianCalendar gregcal = new GregorianCalendar();
		CalDay cal = new CalDay(gregcal);
		int minute=5;
		int month=5;
		int day=5;
		int year=5;
		int hour=5;
		String title="valid appt.";
		String description="this is a valid appt.";
		int secondhour = 4;
		
		
		
		Appt myapp = new Appt(hour,minute,day,month,year,title,description);
		Appt myapptwo = new Appt(secondhour,minute,day,month,year,title,description);
		cal.addAppt(myapp);
		cal.addAppt(myapptwo);
		Iterator<?> testIterator = cal.iterator();
		assertFalse(testIterator.equals(null));
		assertEquals(2, cal.getSizeAppts());
		//String output = cal.toString();
		//System.out.println(output);
		assertFalse(cal.toString().equals(null));
	 }
	 
	 
	 @Test
	  public void test04()  throws Throwable  {
		GregorianCalendar gregcal = new GregorianCalendar();
		CalDay cal = new CalDay(gregcal);
		int minute=70;
		int month=5;
		int day=5;
		int year=5;
		int hour=5;
		String title="valid appt.";
		String description="this is a valid appt.";
		
		Appt myapp = new Appt(hour,minute,day,month,year,title,description);
		cal.addAppt(myapp);
		assertEquals(0, cal.getSizeAppts());
	 }
	 
	 @Test
	  public void test05()  throws Throwable  {
		GregorianCalendar gregcal = new GregorianCalendar();
		CalDay cal = new CalDay(gregcal);
		assertEquals(cal.getDay(), gregcal.get(GregorianCalendar.DAY_OF_MONTH));
		assertEquals(cal.getMonth(), gregcal.get(GregorianCalendar.MONTH));
		assertEquals(cal.getYear(), gregcal.get(GregorianCalendar.YEAR));
	 }
	 
	 
	 
	 
	 
	 /*
	 @Test
	  public void test06()  throws Throwable  {
		boolean diagnose = true;

				
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		System.out.println("Calendar Main: \n" );
		
		
     	
     	int thisMonth;
    	
    	
    	 int thisYear;
    	
    	
    	int thisDay;
    	
		//get todays date
    	Calendar rightnow = Calendar.getInstance();
    	//current month/year/date is today
    	thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		
		
		 int startHour=15;
		 int startMinute=30;
		 int startDay=thisDay; 		//11
		 int startMonth=thisMonth; 	//4
		 int startYear=thisYear;	//2017
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
         
         if(diagnose){
          	System.out.println(appt.toString());
          } 
         
         listAppts.add(appt);
          
      // create another appointment
         startHour=14;
		 startMinute=30;
		 startDay=thisDay;  	//11
		 startMonth=thisMonth; 	//4
		 startYear=thisYear; 	//2017
		 title="Class";
		 description="Rescheduled class.";
		 //Construct a new Appointment object with the initial data	 
         appt = new Appt(startHour,
                  startMinute ,
                  startDay ,
                  startMonth ,
                  startYear ,
                  title,
                 description);
         
         if(diagnose){
         	System.out.println(appt.toString());
         }
         listAppts.add(appt);
         // create another appointment
         startHour=13;
		 startMinute=30;
		 startDay=thisDay;		//11
		 startMonth=thisMonth;	//4
		 startYear=thisYear;	//2017
		 title="Meeting Today";
		 description="Meeting with the students.";
		 //Construct a new Appointment object with the initial data	 
         appt = new Appt(startHour,
                  startMinute ,
                  startDay ,
                  startMonth ,
                  startYear ,
                  title,
                 description);
         
         if(diagnose){
         	System.out.println(appt.toString());
         }
         listAppts.add(appt);
     

		//get a list of appointments for one day, which is today
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		if(diagnose){
			System.out.println("today is:" + today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR));
			System.out.println("tomorrow is:" + tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR));
		}
		
		TimeTable timeTable=new TimeTable();
        //Create a linked list of calendar days to return
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays=timeTable.getApptRange(listAppts,today,tomorrow);
		for(int i=0; i<calDays.size();i++)
			System.out.println(calDays.get(i).toString());

		//delete a particular appointment from the list
		if(diagnose){
			System.out.println("Delete  "+ appt );
		}
		LinkedList<Appt> listUpdatedAppts=timeTable.deleteAppt(listAppts, appt);
		if(diagnose){
			System.out.println("Here's the Latest List of the Appointments ");
		}
		if (listUpdatedAppts!=null) {

			calDays = new LinkedList<CalDay>();
			calDays = timeTable.getApptRange(listAppts, today, tomorrow);
			for (int i = 0; i < calDays.size(); i++)
				System.out.println(calDays.get(i).toString());
		}
        System.exit(0);
		
	 }
	 */
	 

}
