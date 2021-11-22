package pages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Baseclass;

public class LoginPage {

	ExtentTest test= Baseclass.test;
	WebDriver driver = Baseclass.driver;
    
  //**************Web elements****************
    
    @FindBy(name = "user-name")
    WebElement UserName;
    
    @FindBy(id = "password")
    WebElement Password;
    
    
    
    @FindBy(name = "login-button")
    WebElement btn_login;
    
    //@FindBy(id="msg_box")
    //WebElement Error;

  public LoginPage() {
        
        PageFactory.initElements(driver, this);
    }
  
  //******************methods**************
  
    
    public void login(String Uname, String Pass)
    {
    
        
            
       
        //test.log(LogStatus.PASS,"Successfully clicked the link");
        
        UserName.sendKeys(Uname);
        test.log(LogStatus.PASS, "Successfully Entered the Name");
        
        
        Password.sendKeys(Pass);
        test.log(LogStatus.PASS, "Successfully Entered the Password");
        
        
     
        
        btn_login.click();
        test.log(LogStatus.PASS, "Successfully clicked the login Button");
        
    }
    
    public void Errorcheck()
    {

        WebElement error=driver.findElement(By.id("msg_box"));
        String Actualmsg = error.getText();
        String Expmsg = "The email or password you have entered is invalid.";
        

    
        
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Actualmsg, Expmsg);
        
        System.out.println("After Assertion:login check");
        
        soft.assertAll();
    }

}