package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	public Properties prop;

	
	public WebDriver initializeBrowser() throws IOException
	{
		
		
		prop = new Properties();
		String browserpath = System.getProperty("user.dir");
		String projectpath = browserpath+"\\src\\main\\java\\resources\\data.properties";
		
			
		FileInputStream fis = new FileInputStream(projectpath);
		prop.load(fis);
		
		String browsername = prop.getProperty("browser");
		
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			

			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origens=*");
			driver = new ChromeDriver(opt);
				
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		return driver;
				
	}
	
	public String takescreenshot(String testName, WebDriver driver) throws IOException
	{
				
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		
		return destinationFilePath;
	}
	
	
}
