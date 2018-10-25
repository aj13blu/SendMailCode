package Email.EmailTest;

import javax.mail.Message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class EmailTests 
{
	  public static WebDriver driver;	
	  private static EmailUtils emailUtils;

	  @BeforeClass
	  public static void connectToEmail()  {
	    try {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajinkya.bhobad\\Desktop\\jars\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get("http://www.google.com");
	    	driver.get("https://webmail.ixiasolutions.com/");
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//input[@id='rcmloginuser']")).sendKeys("ajinkya.bhobad@ixiasolutions.com");
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//input[@id='rcmloginpwd']")).sendKeys("");//
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//input[@id='rcmloginsubmit']")).click(); 
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//a[contains(text(),'Compose')]")).click(); 
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//*[@id=\"_to\"]")).sendKeys("automation2018.QA@gmail.com");
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//*[@id='composebody']")).sendKeys("Test Automation Mail"); 
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//*[@id='compose-subject']")).sendKeys("Test Automation Mail"); 
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//*[@id=\"rcmbtn107\"]")).click();   
	    
	      emailUtils = new EmailUtils("automation2018.QA@gmail.com", "automation@2018", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
	    } 
	    catch (Exception e) {
	      e.printStackTrace();
	      Assert.fail(e.getMessage());
	    }
	  }
	  
 /* @Test
  public void testVerificationCode() {
    try {
      //TODO: Execute actions to send verification code to email
 
      String verificationCode = emailUtils.getAuthorizationCode();
 
      //TODO: Enter verification code on screen and submit
 
      //TODO: add assertions
 
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail(e.getMessage());
    }
  }*/
  
  @Test
  public void testTextContained() {
    try{
    Message email = emailUtils.getMessagesBySubject("Test Automation Mail", true, 5)[0];
    Assert.assertTrue("Approval message is not in email", emailUtils.isTextInMessage(email, "Test Automation Mail"));
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail(e.getMessage());
    }
  }
  
 /* @Test
  public void testLink() {
    
    //TODO: apply for a loan using criteria that will result in the application being rejected
    
    try{
      Message email = emailUtils.getMessagesBySubject("Test Automation Mail", true, 5)[0];
      String link = emailUtils.getUrlsFromMessage(email, "Click here to view the reason").get(0);
      
      driver.get(link);
      
      //TODO: continue testing
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail(e.getMessage());
    }
  }*/
  
  @AfterClass
  public void aftermethod()
  {
	  driver.close();
  }

}
