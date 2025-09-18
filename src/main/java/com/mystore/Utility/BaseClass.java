package com.mystore.Utility;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// this ".*" importing all Testng Annotation
// this ".*" importing all Testng Annotation
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static ExcelDataProvider excel;
	public static ConfigDataProvider config;
	public static Logger logger;
	public static String RandomString;
	@BeforeSuite
	public void BS() throws IOException
	{
		config=new ConfigDataProvider();
		excel=new ExcelDataProvider();
	}
		
		public String RandomString()
		{
			String generatedstring= RandomStringUtils.randomAlphabetic(6);
			return generatedstring;
		}
	
		
	@BeforeClass
	@Parameters({"browser"})
	public void setup( String browser)
	{

		switch(browser.toLowerCase())
		{
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "edge" :
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			System.out.println("invalid browser name..");

			return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //Applicable for all WebElement
		driver.manage().window().maximize();
		
		//for logging
		logger=LogManager.getLogger("MyStore");
		//open url
		
		


	}

	@AfterClass
	public void tearDown() throws InterruptedException 
	{
		driver.close();
		driver.quit();
	}

	public void captureScreenShot(WebDriver driver, String testName) throws IOException {
		//step1: convert webDriver object to takesScreenshot interface
		File screenshot_source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//Step2: call getScreenShotAs method to create image file
		String screenshotPath=System.getProperty("user.dir")+ "\\sreenshot\\"+"testname"+ ".png";
		File screenshot_destination=new File(screenshotPath);
		
		//Step3: Copy Image file to destination
		FileUtils.copyFile(screenshot_source, screenshot_destination);
		
		}
	
	 
	
	
}
