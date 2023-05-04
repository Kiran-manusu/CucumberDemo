package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	
	public WebDriver driver;
	@Test
	public void testtwo() throws IOException, InterruptedException 
	{
		
		System.out.println("TestTwo Opened.");

		driver = initializeBrowser();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.close();

	}

}
