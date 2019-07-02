/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author pw02327
 */
public class RegisterPage {

    WebDriver driver;
    String browserName;

    @Parameters("browser") 
    @BeforeTest

    public void webDriversetUp(String browserName) {
        
        
        if(browserName.equalsIgnoreCase("chrome")){ 
     
        System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
        
    else{
           System.setProperty("webdriver.gecko.driver", "C://drivers/geckodriver.exe"); 
        driver = new FirefoxDriver();
    }
        driver.manage().window().maximize();
        driver.get("http://newtours.demoaut.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }

    public static String generategetRandomInteger(int min,int max)
    {
        return Integer.toString(min + (int)(Math.random() * ((max - min) + 1)));
    }
      public static String generateRandomString(int length)
    {
        	  String text = "";
		  String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";		   
		  for (int i = 0; i < length; i++)
		    text += possible.charAt((int) Math.floor(Math.random() * possible.length()));		   
		  return text;
    }
      
    @Test(priority = 0, dataProvider = "Registration", dataProviderClass=DataProviderClass.class)
    public void registerUser(String email, String adress, String city, String state, String postalCode,String username, String password, String confirmPassword) throws Exception {
     
     driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
     driver.findElement(By.name("firstName")).sendKeys(generateRandomString(7));
     driver.findElement(By.name("lastName")).sendKeys(generateRandomString(10));
     driver.findElement(By.name("phone")).sendKeys("07"+generategetRandomInteger(1000000,9999999));
     driver.findElement(By.name("userName")).sendKeys(email);
     driver.findElement(By.name("address1")).sendKeys(adress);
     driver.findElement(By.name("city")).sendKeys(city);
     driver.findElement(By.name("state")).sendKeys(state);
     driver.findElement(By.name("postalCode")).sendKeys(postalCode);
     Select drpCountry = new Select(driver.findElement(By.name("country")));
 drpCountry.selectByVisibleText("ROMANIA");
     driver.findElement(By.name("email")).sendKeys(username);
     driver.findElement(By.name("password")).sendKeys(password);
     driver.findElement(By.name("confirmPassword")).sendKeys(confirmPassword);
    }
    
    @AfterTest
    public void closeConnection() {
        driver.quit();
    }

}
