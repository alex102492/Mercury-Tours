package testCases;

import org.testng.annotations.DataProvider;
public class DataProviderClass {
  
 @DataProvider(name="Registration")
 public static Object[][] registerUser()
 {
  return new Object[][]{
	  {"testaretest10@test.com","First Street, no. 10","Buray","Chicago","115400","testaretest10", "Test1","Test1" }
  };
 }

}