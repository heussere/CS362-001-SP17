package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setDescription","setMonth","setDay","setHour","setMinute"};// The list of the of methods to be tested in the Appt class
		//String[] methodArray = new String[] {"setTitle","setDescription"};
    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	
    /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {
		//GregorianCalendar gregcal = new GregorianCalendar();
		//CalDay cal = new CalDay(gregcal);
		TimeTable newTable = new TimeTable();
		LinkedList<Appt> apptList = new LinkedList<Appt>();
		
		 //long startTime = Calendar.getInstance().getTimeInMillis();
		 //long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		 
			for (int i = 0; i < 10000; i++){
			//for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				
				
				
				//long randomseed =10;
				long randomseed = System.currentTimeMillis();
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
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
				//for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
						if (methodName.equals("setDescription")){
						   String newDescription=(String) ValuesGenerator.getString(random);
						   appt.setDescription(newDescription);						   
						}
						if (methodName.equals("setMonth")){
						   int newMonth = ValuesGenerator.getRandomIntBetween(random, -2, 14);
						   appt.setStartMonth(newMonth);						   
						}
						if (methodName.equals("setDay")){
						   int newDay = ValuesGenerator.getRandomIntBetween(random, -2, 32);
						   appt.setStartDay(newDay);						   
						}
						if (methodName.equals("setHour")){
						   int newHour = ValuesGenerator.getRandomIntBetween(random, -2, 26);
						   appt.setStartHour(newHour);						   
						}
						if (methodName.equals("setMinute")){
						   int newMinute = ValuesGenerator.getRandomIntBetween(random, -2, 62);
						   appt.setStartMinute(newMinute);						   
						}
					
				//}
				
				// elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			     //   if((iteration%10000)==0 && iteration!=0 )
			      //        System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			 //cal.addAppt(appt);
			 
			 
			 
			 
			 int thisCase = ValuesGenerator.getRandomIntBetween(random,0,2);
			 //int thisCase = random.nextInt(3);
			 
			 //System.out.println("first random: "+thisCase);
			 if (thisCase==0){
				 apptList.add(appt);
			 }
			 else if (thisCase==1){
				 apptList.add(appt);
				 newTable.deleteAppt(apptList,appt);
			 }
			 else if (thisCase==2){
				 newTable.deleteAppt(apptList,appt);
			 }
			 
			 thisCase = ValuesGenerator.getRandomIntBetween(random,0,10);
			 //thisCase = random.nextInt(10)+1;
			// System.out.println("second random: "+thisCase);
			 if (thisCase==9) {
				// System.out.println("null entered");
				 Appt nullAppt = null;
				 newTable.deleteAppt(apptList,nullAppt);
			 }
			 if (thisCase==8) {
				 LinkedList<Appt> nullList = null;
				 newTable.deleteAppt(nullList,appt);
			 }
			 
			}
	 
	 
		 System.out.println("Done testing...");
	 }


	
}
