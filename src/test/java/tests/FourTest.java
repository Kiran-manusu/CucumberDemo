package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void testfour() throws IOException, InterruptedException 
	{
		
		System.out.println("TestFour Opened.");
		
		driver = initializeBrowser();
		System.out.println("Initialization Started.");
		
		
		driver.get("https://tutorialsninja.com/demo/");
		
		Assert.assertTrue(false);
		

	}
	
	@AfterMethod
	public void closewindow()
	{
		driver.close();
	}

}
