package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {
	
	ExtentReports extentreport = ExtentReporter.getExtentreport();
	
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	
	ExtentTest extenttest;
	
	public WebDriver driver;

	@Override
	public void onTestStart(ITestResult result)
	{
		String testname = result.getName();
		extenttest = extentreport.createTest(testname);
		
		extentTestThread.set(extenttest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		String testname = result.getName();
		//extenttest.log(Status.PASS,testname+" got passed.");
		
		extentTestThread.get().log(Status.PASS,testname+" got passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
			String testMethodName = result.getName();			
			//extenttest.fail(result.getThrowable());
					
			extentTestThread.get().fail(result.getThrowable());
			
			try
			{				
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());				
			}
			catch (Exception e)
			{			
				e.printStackTrace();
			}
	
		
		try
		{			
			String screenshotFilePath = takescreenshot(testMethodName,driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}		

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		extentreport.flush();
	}

}
