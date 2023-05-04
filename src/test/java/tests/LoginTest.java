package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Accountpage;
import pageobjects.Landingpage;
import pageobjects.Loginpage;
import resources.Base;

public class LoginTest extends Base
{
	public WebDriver driver;
	Logger logger;
	
	@BeforeMethod
	public void openApplication() throws IOException
	{
		logger = LogManager.getLogger(Base.class.getName());
		
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		
		logger.debug("Browser URL loaded from properties file.");
	}
	
	@Test(dataProvider = "getlogindata")
	public void login(String email,String password, String expectedResult) throws IOException, InterruptedException
	{
		
	 
		
		Landingpage landingpage = new Landingpage(driver);
		
		logger.debug("Landingpage class object created.");
		
		landingpage.myaccountdropdown().click();
		landingpage.accountloginpage().click();
		Thread.sleep(2000);
		
		Loginpage loginpage = new Loginpage(driver);
		
		logger.debug("Loginpage class object created.");
		//loginpage.emailid().sendKeys(prop.getProperty("email"));
		//loginpage.password().sendKeys(prop.getProperty("password"));
		
		loginpage.emailid().sendKeys(email);
		loginpage.password().sendKeys(password);
		loginpage.submitbutton().click();
				
		Accountpage accountpage = new Accountpage(driver);
		
		logger.debug("Accountpage class object created.");
		//Assert.assertTrue(accountpage.myaccountpage().isDisplayed());
		
		String actualresult= null;
		try
		{
			if(accountpage.myaccountpage().isDisplayed())
			{
				actualresult="Success";
				logger.debug("Account page is displayed.");
			}
		}
		catch (Exception e)
		{
			actualresult="Failure";
			logger.debug("Account page is not displayed.");
		}
	Assert.assertEquals(actualresult, expectedResult);
	logger.info("Login Test will be passed. ");
	}
	
	
	@AfterMethod
	public void closemethod()
	{
		driver.quit();
		logger.debug("Browser is closed.");
	}
	
	@DataProvider
	public Object[][] getlogindata()
	{
		// One Set of Data passed
		Object[][] data = {{"kiran1234@gmail.com","123456789","Success"}};
		
		// Two sets of Data passed
		//Object[][] data = {{"kiran1234@gmail.com","123456789","Success"},{"kiran123@gmail.com","12345678","Failure"}};
		return data;
	}

}
