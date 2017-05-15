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
		assertEquals(4,cal.getAppts().get(0).getStartHour());
		//String output = cal.toString();
		//System.out.println(output);
		assertFalse(cal.toString().equals(null));
		
		//assertEquals("\t --- 4/14/2017 --- \n --- -------- Appointments ------------ --- \n\t5/5/5 at 4:5am ,valid appt., this is a valid appt.\n \t5/5/5 at 5:5am ,valid appt., this is a valid appt.\n \n",cal.toString());
		String temp = "\t --- "+(gregcal.get(gregcal.MONTH))+"/"+gregcal.get(gregcal.DAY_OF_MONTH)+"/"+gregcal.get(gregcal.YEAR)+" --- \n --- -------- Appointments ------------ --- \n\t5/5/5 at 4:5am ,valid appt., this is a valid appt.\n \t5/5/5 at 5:5am ,valid appt., this is a valid appt.\n \n";
		assertEquals(temp,cal.toString());
		}
/*		String todayDate = (getMonth()) + "/" + getDay() + "/" + getYear();
175		
			sb.append("\t --- " + todayDate + " --- \n");
176		
			sb.append(" --- -------- Appointments ------------ --- \n");///

			*/
		/*
	 [    --- 4/14/2017 ---
 --- -------- Appointments ------------ ---
        5/5/5 at 4:5am ,valid appt., this is a valid appt.
       ]5/5/5 at 5:5am ,vali...> but was:<[      --- 4/14/2017 ---
 --- -------- Appointments ------------ ---
        5/5/5 at 4:5am ,valid appt., this is a valid appt.
        ]5/5/5 at 5:5am ,vali...>
	 */
	 
	 
	 
	 
	 
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
	 
	 @Test
	  public void test06()  throws Throwable  {
		GregorianCalendar gregcal = new GregorianCalendar();
		CalDay cal = new CalDay(gregcal);
		assertFalse(cal.getAppts()==null);
		int minute=5;
		int month=5;
		int day=5;
		int year=5;
		int hour=5;
		String title="valid appt.";
		String description="this is a valid appt.";
		//int secondhour = 6;
		int secondhour = 5;
		int secondminute = 10;
		
		Appt myapp = new Appt(hour,minute,day,month,year,title,description);
		Appt myapptwo = new Appt(secondhour,secondminute,day,month,year,title,description);
		cal.addAppt(myapp);
		cal.addAppt(myapptwo);
		Iterator<?> testIterator = cal.iterator();
		assertFalse(testIterator.equals(null));
		assertEquals(2, cal.getSizeAppts());
		assertEquals(5,cal.getAppts().get(0).getStartMinute());
		//String output = cal.toString();
		//System.out.println(output);
		assertFalse(cal.toString().equals(null));
	 }
	 

}
