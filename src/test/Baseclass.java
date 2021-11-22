
package test;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Baseclass {
	
	
	public  static ExtentReports report;
	public  static ExtentTest test;
	
	public static WebDriver driver;
	
	 
	 @BeforeTest
	 public void ReportSetup() {
		 report =new ExtentReports("ExtentReport.html");
	 }
	 
	 
	@BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        
        driver = new ChromeDriver();
        
        
//        System.setProperty("webdriver.gecko.driver","geckodriver");
//        
//        WebDriver driver  = new FirefoxDriver    ();
//        
        driver.get("https://www.saucedemo.com/");
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        
    }
    
   
    
    @AfterMethod
    public void teardown() {
        
        driver.quit();
        
    }
   @AfterTest
	 public void ReportTearDown() {
		 report.flush();
		 report.close();
	 }
	 

}



