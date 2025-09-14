package com.mystore.Utility;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;                  // this ".*" importing all Testng Annotation

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static ExcelDataProvider excel;
	public static ConfigDataProvider config;
	public static Logger logger;
	
	@BeforeSuite 
	public void BS() throws IOException {
	 config=new ConfigDataProvider();
	 excel=new ExcelDataProvider(); 
	 
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
		
		
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		//driver.close();
		//driver.quit();
	}

}
