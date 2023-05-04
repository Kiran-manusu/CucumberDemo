package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports extentreport; 
	
	
	public static ExtentReports getExtentreport()
	{
		String pathofproject = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(pathofproject);
		reporter.config().setReportName("Ninjatutorial Test report");
		reporter.config().setDocumentTitle("Ninjatutorial Test report title");
		
		extentreport = new ExtentReports();
		extentreport.attachReporter(reporter);
		
		extentreport.setSystemInfo("Operating System", "Windows 10");
		extentreport.setSystemInfo("Tested By", "Kiran");
		
		return extentreport;	
	}
	
	

}
