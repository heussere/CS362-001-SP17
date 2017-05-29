package edu.osu.cs362;


import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
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
		GregorianCalendar gregcal = new GregorianCalendar();
		CalDay cal = new CalDay(gregcal);

		 //long startTime = Calendar.getInstance().getTimeInMillis();
		 //long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		 
			for (int i = 0; i < 500000; i++){
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
			 
			 cal.addAppt(appt);
			}
	 
	 
		 System.out.println("Done testing...");
	 }


	
}
