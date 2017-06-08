/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   assertTrue(urlVal.isValid("http://www.amazon.com"));
	   assertTrue(urlVal.isValid("https://www.google.com"));
	   assertFalse(urlVal.isValid("asdfasdfasdfasdf"));
	   assertFalse(urlVal.isValid("www.thisiswrong."));
	   assertTrue(urlVal.isValid("https://www.testvalidforeign.de"));
	   assertTrue(urlVal.isValid("https://www.asdf.com"));
	   assertTrue(urlVal.isValid("http://testurl.com/stuff/morestuff"));
	   assertTrue(urlVal.isValid("https://www.asdfasdfasdfasdfasfasdfasdfasdfasdfasdhalsdfhasdfhsoaijfhadsufasodfhoaisuhfoaisudhfuidoasiusdhfudsoaisudhfudsioaiuhasdoifuhasdofiuhasdoiuhasdfoiuhasdfoiuhasdfiouhasdfoiuhasdfoiuhasdiouhasdhfuofdaiuhsdufiodasiushdfuoidsaisudhfudsoasidufhdsuoasidufhfdsaoiuhasdfoiuhasdfoiuhasdfoiuhasdfoiuhasdfoiuhasdfoiuhasdfoiuhasdf.com"));
	   assertTrue(urlVal.isValid("https://www.immigration.govt.it"));
	   
	   
		//tests below return false when they shouldn't
	   assertFalse(urlVal.isValid("http://23.420.23.55"));
	   assertTrue(urlVal.isValid("http://testurl.com/stuff/morestuff?queryvalue=foo"));
	   assertTrue(urlVal.isValid("https://www.immigration.govt.nz"));
	   
   }
   
   
    //urls that terminate with .gov,.com,.edu or .org
   public void testYourFirstPartition()
   {
        UrlValidator urlVal = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertTrue(urlVal.isValid("https://www.google.com"));
        assertTrue(urlVal.isValid("https://www.x.org"));
        assertTrue(urlVal.isValid("https://www.jhsavhcnoaucjnscunowidcmls.gov"));
        assertFalse(urlVal.isValid("https://www.sms.s//s.f/.org"));
        assertFalse(urlVal.isValid("www.x.org"));
   }
   //urls that don't terminate with .gov,.com, or .org
   public void testYourSecondPartition()
   {
           UrlValidator urlVal = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);
           assertTrue(urlVal.isValid("https://www.google.it"));
           assertFalse(urlVal.isValid("www.x.net"));
           assertFalse(urlVal.isValid("https://www.eme.s//s.f/.biz"));
		   //test below returns false when it shouldn't
		   assertTrue(urlVal.isValid("https://www.x.ru"));
   }

   
   
   public void testIsValid()
   {
	   boolean validA, validB, validC, validD, validE, validF=true;
	int numErrors=0;
	UrlValidator urlVal = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);
	String stringA, stringB, stringC, stringD, stringE, stringF = "";
	//String builtString;
	boolean isPerfect=true;//set to false if any of our assertions fail
	
	for (int a = 0; a < testUrlScheme.length; a++){
		validA=testUrlScheme[a].valid;
		stringA = testUrlScheme[a].item;
		for (int b = 0; b < testUrlAuthority.length; b++){
			stringB = stringA;
			stringB += testUrlAuthority[b].item;
			validB=true;
			
			
			
			
			if (validA==false || ( testUrlAuthority[b].valid==false)) validB=false;
			for (int c = 0; c < testUrlPort.length; c++){
				stringC = stringB;
				stringC += testUrlPort[c].item;
				validC=true;
				
				
							
							
				if (validB==false || ( testUrlPort[c].valid==false)) validC=false;
				for (int d = 0; d < testPath.length; d++){
					stringD = stringC;
					stringD += testPath[d].item;
					validD=true;
					
					
					
					
					
					if (validC==false || ( testPath[d].valid==false)) validD=false;
					for (int e = 0; e < testUrlPathOptions.length; e++){
						stringE = stringD;
						stringE += testUrlPathOptions[e].item;
						validE=true;
						
						
						
						if (validD==false || ( testUrlPathOptions[e].valid==false)) validE=false;
						for (int f = 0; f < testUrlQuery.length; f++){
							stringF = stringE;
							stringF += testUrlQuery[f].item;
							validF=true;
							if (validE==false || ( testUrlQuery[f].valid==false)) validF=false;
							
							
							
							/*if (!urlVal.isValid(stringF)){
								System.out.println("ERROR: expected isValid() to return true for "+stringF);
									numErrors++;
									isPerfect=false;
							}*/
							
							if (validF) {
								if (!urlVal.isValid(stringF)) {
									System.out.println("ERROR: expected isValid() to return true for "+stringF);
									numErrors++;
									isPerfect=false;
								//assertTrue("True value expected for "+builtString,urlVal.isValid(builtString));
							}
							}
							else {
								if (urlVal.isValid(stringF)) { 
									System.out.println("ERROR: expected isValid() to return false for " + stringF);
									numErrors++;
									isPerfect=false;
									//assertFalse("False value expected for " + builtString,urlVal.isValid(builtString));
							}
								
							}
							
							
							
							
							
						}
					}
				}
				
			}
		}
		
	}
	System.out.println("Number of errors found in testing: "+numErrors);
	assertTrue("There were errors in programmatic testing.",isPerfect);
	   
	
	
	 
   }
   
   
   
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
/*ResultPair[] testUrlScheme = {new ResultPair("http://", true),
                               new ResultPair("ftp://", true),
                               new ResultPair("h3t://", true),
                               new ResultPair("3ht://", false),
                               new ResultPair("http:/", false),
                               new ResultPair("http:", false),
                               new ResultPair("http/", false),
                               new ResultPair("://", false),
                               new ResultPair("", true)};

   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
                                  new ResultPair("go.com", true),
                                  new ResultPair("go.au", true),
                                  new ResultPair("0.0.0.0", true),
                                  new ResultPair("255.255.255.255", true),
                                  new ResultPair("256.256.256.256", false),
                                  new ResultPair("255.com", true),
                                  new ResultPair("1.2.3.4.5", false),
                                  new ResultPair("1.2.3.4.", false),
                                  new ResultPair("1.2.3", false),
                                  new ResultPair(".1.2.3.4", false),
                                  new ResultPair("go.a", false),
                                  new ResultPair("go.a1a", false),
                                  new ResultPair("go.cc", true),
                                  new ResultPair("go.1aa", false),
                                  new ResultPair("aaa.", false),
                                  new ResultPair(".aaa", false),
                                  new ResultPair("aaa", false),
                                  new ResultPair("", false)
   };
   ResultPair[] testUrlPort = {new ResultPair(":80", true),
                             new ResultPair(":65535", true),
                             new ResultPair(":0", true),
                             new ResultPair("", true),
                             new ResultPair(":-1", false),
                             new ResultPair(":65636", true),
                             new ResultPair(":65a", false)
   };
   ResultPair[] testPath = {new ResultPair("/test1", true),
                          new ResultPair("/t123", true),
                          new ResultPair("/$23", true),
                          new ResultPair("/..", false),
                          new ResultPair("/../", false),
                          new ResultPair("/test1/", true),
                          new ResultPair("", true),
                          new ResultPair("/test1/file", true),
                          new ResultPair("/..//file", false),
                          new ResultPair("/test1//file", false)
   };
   //Test allow2slash, noFragment
   ResultPair[] testUrlPathOptions = {new ResultPair("/test1", true),
                                    new ResultPair("/t123", true),
                                    new ResultPair("/$23", true),
                                    new ResultPair("/..", false),
                                    new ResultPair("/../", false),
                                    new ResultPair("/test1/", true),
                                    new ResultPair("/#", false),
                                    new ResultPair("", true),
                                    new ResultPair("/test1/file", true),
                                    new ResultPair("/t123/file", true),
                                    new ResultPair("/$23/file", true),
                                    new ResultPair("/../file", false),
                                    new ResultPair("/..//file", false),
                                    new ResultPair("/test1//file", true),
                                    new ResultPair("/#/file", false)
   };

   ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
                              new ResultPair("?action=edit&mode=up", true),
                              new ResultPair("", true)
   };  */


ResultPair[] testUrlScheme = {new ResultPair("http://", true),
                               new ResultPair("ftp://", true),
                               new ResultPair("h3t://", true),
							   new ResultPair("3ht://", false),
                               new ResultPair("http:/", false),
                               new ResultPair("http:", false),
                               new ResultPair("http/", false),
                               new ResultPair("://", false),
							   new ResultPair("", false)
							   };

   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
                                  new ResultPair("go.com", true),
                                  new ResultPair("go.au", true),
                                  new ResultPair("0.0.0.0", true),
                                  new ResultPair("255.255.255.255", true),
                                  new ResultPair("256.256.256.256", false),
                                  new ResultPair("255.com", true),  
								  new ResultPair("1.2.3.4.5", false),
                                  new ResultPair("1.2.3.4.", false),
                                  new ResultPair("1.2.3", false),
                                  new ResultPair(".1.2.3.4", false),
                                  new ResultPair("go.a", false),
                                  new ResultPair("go.a1a", false),
                                  new ResultPair("go.cc", true),
                                  new ResultPair("go.1aa", false),
                                  new ResultPair("aaa.", false),
                                  new ResultPair(".aaa", false),
                                  new ResultPair("aaa", false),
                                  new ResultPair("", false)
								  
								  
   };
   ResultPair[] testUrlPort = {new ResultPair(":80", true),
                             new ResultPair(":65535", true),
                             new ResultPair(":0", true),
                             new ResultPair("", true),
                          
						     new ResultPair(":-1", false),
                             new ResultPair(":65636", true),
                          
						     new ResultPair(":65a", false)
   };
   ResultPair[] testPath = {new ResultPair("/test1", true),
                          new ResultPair("/t123", true),
                          new ResultPair("/$23", true),
                          //new ResultPair("/..", false),
                          //new ResultPair("/../", false),
                          new ResultPair("/test1", true),//slash
                          //new ResultPair("", true),
                          new ResultPair("/test1/file", true)//,
                          //new ResultPair("/..//file", false),
                          //new ResultPair("/test1//file", false)
   };
   //Test allow2slash, noFragment
   ResultPair[] testUrlPathOptions = {new ResultPair("/test1", true),
                                    new ResultPair("/t123", true),
                                    new ResultPair("/$23", true),
                                    //new ResultPair("/..", false),
                                    //new ResultPair("/../", false),     
								    new ResultPair("/test1", true),//slash
                                    //new ResultPair("/#", false),
                                    //new ResultPair("", true),
                                    new ResultPair("/test1/file", true),
                                    new ResultPair("/t123/file", true),
                                    new ResultPair("/$23/file", true),
                                    //new ResultPair("/../file", false),
                                    new ResultPair("/..//file", false)
                                    //new ResultPair("/test1//file", true),
                                    //new ResultPair("/#/file", false)
   };

   ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
                              new ResultPair("?action=edit&mode=up", true),
                              new ResultPair("", true)
   };

ResultPair[] testScheme = {new ResultPair("http", true),
                            new ResultPair("ftp", false),
                            new ResultPair("httpd", false),
                            new ResultPair("telnet", false)//};


};   

}
