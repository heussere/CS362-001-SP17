package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		int thisMonth;
    	int thisYear;
    	int thisDay;
    	Calendar rightnow = Calendar.getInstance();
    	//current month/year/date is today
    	thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		
		 LinkedList<Appt> inputAppts = new LinkedList<Appt>();
		 LinkedList<CalDay> outputAppts = new LinkedList<CalDay>();
		 
		 
		 TimeTable newTable = new TimeTable();
		 
		 outputAppts = newTable.getApptRange(inputAppts,today,tomorrow);
		 //System.out.println("TEST ONE "+outputAppts.size());
		assertEquals(1, outputAppts.size());
	 }
	 
	 @Test
	  public void test02()  throws Throwable  {
		int thisMonth;
    	int thisYear;
    	int thisDay;
    	Calendar rightnow = Calendar.getInstance();
    	//current month/year/date is today
    	thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		
		 LinkedList<Appt> inputAppts = new LinkedList<Appt>();
		 LinkedList<CalDay> outputAppts = new LinkedList<CalDay>();
		 
		 
		 TimeTable newTable = new TimeTable();
		 
		 try {
		 outputAppts = newTable.getApptRange(inputAppts,tomorrow,today);
		 fail("An exception was not generated where expected.");
		 }
		 catch (IllegalArgumentException e){
			 
		 }
	 }
	 
	 @Test
	  public void test03()  throws Throwable  {
		int thisMonth;
    	int thisYear;
    	int thisDay;
    	Calendar rightnow = Calendar.getInstance();
    	//current month/year/date is today
    	thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		
		 LinkedList<Appt> inputAppts = new LinkedList<Appt>();
		 LinkedList<CalDay> outputAppts = new LinkedList<CalDay>();
		 TimeTable newTable = new TimeTable();
		 Appt appt1 = new Appt(12,30,10,10,2010,"old appt,","this is an old appt");
		 Appt appt2 = new Appt(10,15,24,4,2017,"current appt","this is a current appt");
		 inputAppts.add(appt1);
		 inputAppts.add(appt2);
		 
		 outputAppts = newTable.getApptRange(inputAppts,today,tomorrow);
	 }

	 @Test
	  public void test04()  throws Throwable  {
		int thisMonth;
    	int thisYear;
    	int thisDay;
		
		 LinkedList<Appt> inputAppts = new LinkedList<Appt>();
		 TimeTable newTable = new TimeTable();
		 Appt appt1 = new Appt(12,30,10,10,2010,"old appt,","this is an old appt");
		 Appt appt2 = new Appt(10,15,24,4,2017,"current appt","this is a current appt"); 
		 Appt appt3 = new Appt(11,15,25,5,2017,"current appt","this is a current appt");
		
		 inputAppts.add(appt1);
		 inputAppts.add(appt2);
		 inputAppts.add(appt3);
		 inputAppts = newTable.deleteAppt(inputAppts,appt3);
		 assertEquals(2, inputAppts.size());
		 
		 
	 }
	 
	 @Test
	  public void test05()  throws Throwable  {
		int thisMonth;
    	int thisYear;
    	int thisDay;
		
		 LinkedList<Appt> inputAppts = new LinkedList<Appt>();
		 TimeTable newTable = new TimeTable();
		 Appt appt1 = new Appt(12,30,10,10,2010,"old appt,","this is an old appt");
		 Appt appt2 = new Appt(10,15,24,4,2017,"current appt","this is a current appt");
		 inputAppts.add(appt1);
		 inputAppts.add(appt2);
		 inputAppts = null;
		 inputAppts = newTable.deleteAppt(inputAppts,appt1);
		 assertEquals(inputAppts,null);
		 
		 
	 }
	 
	 @Test
	  public void test06()  throws Throwable  {
		int thisMonth;
    	int thisYear;
    	int thisDay;
		
		 LinkedList<Appt> inputAppts = new LinkedList<Appt>();
		 TimeTable newTable = new TimeTable();
		 Appt appt1 = new Appt(12,30,10,10,2010,"old appt,","this is an old appt");
		 Appt appt2 = new Appt(10,15,24,4,2017,"current appt","this is a current appt");
		 Appt invalidappt = new Appt(10,9000,24,4,2017,"current appt","this is a current appt");
				
		inputAppts.add(appt1);
		 inputAppts.add(appt2);
		 
		 inputAppts = newTable.deleteAppt(inputAppts,invalidappt);
		 assertEquals(inputAppts,null);
		 
		 
	 }
	  @Test
	  public void test07()  throws Throwable  {
		int thisMonth;
    	int thisYear;
    	int thisDay;
		
		 LinkedList<Appt> inputAppts = new LinkedList<Appt>();
		 TimeTable newTable = new TimeTable();
		 Appt appt1 = new Appt(12,30,10,10,2010,"old appt,","this is an old appt");
		 inputAppts = newTable.deleteAppt(inputAppts,appt1);
		 assertEquals(inputAppts,null);
		 
		 
	 }
	 @Test
	 public void test08()  throws Throwable  {
		int thisMonth;
    	int thisYear;
    	int thisDay;
    	Calendar rightnow = Calendar.getInstance();
    	//current month/year/date is today
    	thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		GregorianCalendar twodays = (GregorianCalendar)tomorrow.clone();
		twodays.add(Calendar.DAY_OF_MONTH,1);
		
		
		 LinkedList<Appt> inputAppts = new LinkedList<Appt>();
		 Appt appt1 = new Appt(5,9000,10,10,2010,"old appt,","this is an old appt");
		 Appt appt2 = new Appt(5,5,thisDay,thisMonth,thisYear,"today's appt","this is today's appt");
		 Appt appt3 = new Appt(5,5,tomorrow.DAY_OF_MONTH,tomorrow.MONTH,tomorrow.YEAR,"tomorrow's appt","this is tomorrow's appt");
		inputAppts.add(appt1);
		inputAppts.add(appt2);
		inputAppts.add(appt3);
		 LinkedList<CalDay> outputAppts = new LinkedList<CalDay>();
		 
		 
		 TimeTable newTable = new TimeTable();
		 
		 outputAppts = newTable.getApptRange(inputAppts,today,twodays);
		 //System.out.println("TEST TWO "+outputAppts.size());
		 assertEquals(2, outputAppts.size());
	 }
	 @Test
	 public void test09()  throws Throwable  {
		int thisMonth;
    	int thisYear;
    	int thisDay;
    	Calendar rightnow = Calendar.getInstance();
    	//current month/year/date is today
    	thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		GregorianCalendar twodays = (GregorianCalendar)tomorrow.clone();
		twodays.add(Calendar.DAY_OF_MONTH,1);
		
		
		 LinkedList<Appt> inputAppts = new LinkedList<Appt>();
		 Appt appt1 = new Appt(5,9,tomorrow.DAY_OF_MONTH,tomorrow.MONTH,tomorrow.YEAR,"old appt,","this is an old appt");
		 Appt appt2 = new Appt(5,5,thisDay,thisMonth,thisYear,"today's appt","this is today's appt");
		 Appt appt3 = new Appt(5,5,thisDay,thisMonth,thisYear,"tomorrow's appt","this is tomorrow's appt");
		 Appt appt4 = new Appt(5,5,thisDay,thisMonth,thisYear,"tomorrow's appt","this is tomorrow's appt");
		//inputAppts.add(appt1);
		inputAppts.add(appt2);
		inputAppts.add(appt3);
		inputAppts.add(appt4);
		//assertEquals(inputAppts.size(),3);
		 LinkedList<CalDay> outputAppts = new LinkedList<CalDay>();
		 
		 
		 TimeTable newTable = new TimeTable();
		 
		 outputAppts = newTable.getApptRange(inputAppts,today,twodays);
		 //System.out.println("TEST TWO "+outputAppts.size());
		 assertEquals(2, outputAppts.size());
		 assertEquals(3, outputAppts.get(0).getSizeAppts());
		 //assertEquals(5, outputAppts.get(1).getSizeAppts());
		 //assertEquals(1, outputAppts.get(2).getSizeAppts());
	 }
	@Test
	 public void test10()  throws Throwable  {
		int thisMonth;
    	int thisYear;
    	int thisDay;
    	Calendar rightnow = Calendar.getInstance();
    	//current month/year/date is today
    	thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		GregorianCalendar twodays = (GregorianCalendar)tomorrow.clone();
		twodays.add(Calendar.DAY_OF_MONTH,1);
		
		
		 LinkedList<Appt> inputAppts = new LinkedList<Appt>();
		 Appt appt1 = new Appt(5,9,tomorrow.DAY_OF_MONTH,tomorrow.MONTH,tomorrow.YEAR,"old appt,","this is an old appt");
		 Appt appt2 = new Appt(5,5,thisDay,thisMonth,thisYear,"today's appt","this is today's appt");
		 //Appt appt3 = new Appt(5,5,thisDay,thisMonth,thisYear,"tomorrow's appt","this is tomorrow's appt");
		 //Appt appt4 = new Appt(5,5,thisDay,thisMonth,thisYear,"tomorrow's appt","this is tomorrow's appt");
		//inputAppts.add(appt1);
		inputAppts.add(appt2);
		//inputAppts.add(appt3);
		//inputAppts.add(appt4);
		//assertEquals(inputAppts.size(),3);
		 LinkedList<Appt> outputAppts = new LinkedList<Appt>();
		 TimeTable newTable = new TimeTable();
		 outputAppts = newTable.deleteAppt(inputAppts,appt1);
		 
		 
		 
		 //assertEquals(1, outputAppts.size());
		 assertEquals(null, outputAppts);
		 
		 
	 }
	 @Test
	 public void test11()  throws Throwable  {
		int thisMonth;
    	int thisYear;
    	int thisDay;
    	Calendar rightnow = Calendar.getInstance();
    	//current month/year/date is today
    	thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		GregorianCalendar twodays = (GregorianCalendar)tomorrow.clone();
		twodays.add(Calendar.DAY_OF_MONTH,1);
		GregorianCalendar threedays = (GregorianCalendar)twodays.clone();
		threedays.add(Calendar.DAY_OF_MONTH,1);
		
		rightnow.add(Calendar.DAY_OF_MONTH,1);
		Calendar tomorrowCalendar = (Calendar)rightnow.clone();
		rightnow.add(Calendar.DAY_OF_MONTH,1);
		Calendar twoDaysCalendar = (Calendar)rightnow.clone();
		//int tomorrowDay=rightnow.get(Calendar.DAY_OF_MONTH);
		//rightnow.add(Calendar.DAY_OF_MONTH,1);
		//int twoDays=rightnow.get(Calendar.DAY_OF_MONTH);
		//System.out.println(thisDay);
		//System.out.println(tomorrowCalendar.get(Calendar.DAY_OF_MONTH));
		//System.out.println(twoDaysCalendar.get(Calendar.DAY_OF_MONTH)); 
		
		 LinkedList<Appt> inputAppts = new LinkedList<Appt>();
		 //Appt appt1 = new Appt(5,9,tomorrow.DAY_OF_MONTH,tomorrow.MONTH,tomorrow.YEAR,"old appt,","this is an old appt");
		 Appt appt2 = new Appt(5,5,thisDay,thisMonth,thisYear,"today's appt","this is today's appt");
		 
		 //Appt appt3 = new Appt(5,5,thisDay+1,thisMonth,thisYear,"tomorrow's appt","this is tomorrow's appt");
		 //Appt appt4 = new Appt(5,5,thisDay+2,thisMonth,thisYear,"tomorrow's appt","this is tomorrow's appt");
		 Appt appt3 = new Appt(5,5,tomorrowCalendar.get(Calendar.DAY_OF_MONTH),tomorrowCalendar.get(Calendar.MONTH)+1,tomorrowCalendar.get(Calendar.YEAR),"tomorrow's appt","this is tomorrow's appt");
		 Appt appt4 = new Appt(5,5,twoDaysCalendar.get(Calendar.DAY_OF_MONTH),twoDaysCalendar.get(Calendar.MONTH)+1,twoDaysCalendar.get(Calendar.YEAR),"tomorrow's appt","this is tomorrow's appt");
		inputAppts.add(appt3);
		inputAppts.add(appt2);
		inputAppts.add(appt4);
		//inputAppts.add(appt2);
		//inputAppts.add(appt3);
		//inputAppts.add(appt4);
		//assertEquals(inputAppts.size(),3);
		 LinkedList<CalDay> outputAppts = new LinkedList<CalDay>();
		 TimeTable newTable = new TimeTable();
		 
		 outputAppts = newTable.getApptRange(inputAppts, today, threedays);
		 
		 
		 assertEquals(1, outputAppts.get(0).getSizeAppts());
		 assertEquals(1, outputAppts.get(2).getSizeAppts());
		assertEquals(1, outputAppts.get(1).getSizeAppts());
		 
		 
	 }
	 }
