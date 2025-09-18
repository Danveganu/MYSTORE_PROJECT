		package com.mystore.Utility;
		
		import java.io.File;
		import org.testng.ITestContext;
		import org.testng.ITestListener;
		import org.testng.ITestResult;
		import com.aventstack.extentreports.ExtentReports;
		import com.aventstack.extentreports.ExtentTest;
		import com.aventstack.extentreports.Status;
		import com.aventstack.extentreports.markuputils.ExtentColor;
		import com.aventstack.extentreports.markuputils.MarkupHelper;
		import com.aventstack.extentreports.reporter.ExtentSparkReporter;
		import com.aventstack.extentreports.reporter.configuration.Theme;

		public class ListenerClass extends BaseClass implements ITestListener 
		{

		ExtentSparkReporter htmlReporter;
		ExtentReports reports;
		ExtentTest test;
	
		public void configureReport()
		{
		htmlReporter= new ExtentSparkReporter("MystoreProjectReport"); 
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		
	//add system information/ environment details to report
		
		reports.setSystemInfo("Machin:", "testpc1");
		reports.setSystemInfo("OS:", "Windows 11");
		reports.setSystemInfo("User:", "Ganesh");
		reports.setSystemInfo("Browser", "Chrome");
		
	//Configuration to Change look and feels 
		
		htmlReporter.config().setDocumentTitle("MYSTORE_PROJECT_REPORT");
		htmlReporter.config().setReportName("MYSTORE");
		htmlReporter.config().setTheme(Theme.DARK);
		}
		
		public void onStart(ITestContext Result) 
		{
		configureReport();
		System.out.println("on start method invoked");
		}
	
	
	//onfinish method is called after all tests are excecuted
		
		public void onFinish(ITestContext Result)
		{
		System.out.println("on finished method invoked");
		reports.flush();   // mandatory for writing report
    	}
	
		//When test case get failed this test case called
		
		@Override
		public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed:"+ result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of failed test case is:"+ result.getName(), ExtentColor.RED));
		
		String screenshotPath=System.getProperty("user.dir")+ "\\sreenshot\\"+ result.getName()+ ".png";
		File ScreenShotFile=new File(screenshotPath);
		test.fail("Captured Screenshot is below:"+ test.addScreenCaptureFromPath(screenshotPath));
		}
		
		@Override
		public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method Skipped:"+ result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of Skipped test case is:"+ result.getName(), ExtentColor.YELLOW));
		}
		
		@Override
		public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method passed:"+ result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of passed test case is:"+ result.getName(), ExtentColor.GREEN));
		}
		
		}
