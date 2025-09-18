package com.mystore.testcase;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.Utility.BaseClass;
import com.mystore.pageobject.AccountCreationDetailsPage;
import com.mystore.pageobject.AddMyAdressPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccountPage;

public class TC_AccountCreationDetailsTest extends BaseClass {
	String randomestring=RandomString();
	
	@Test
	public void verifyaccountDetails() throws IOException {
		driver.get(config.getAppURL());
		logger.info("url opened");
		IndexPage Inpage=new IndexPage(driver);
		Inpage.clickSignInLink();

		MyAccountPage myaccPage=new MyAccountPage(driver);
	
		myaccPage.enterEmailAdress(randomestring+"@gmail.com");
		myaccPage.clickSubmitCreate();
		logger.info("Click On Account Create Button");

		String Actualurl=driver.getCurrentUrl();
		String expectedurl="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
		Assert.assertEquals(Actualurl, expectedurl);
		logger.info("we are on correct url now");
		
		AccountCreationDetailsPage usrdetails=new AccountCreationDetailsPage(driver);
		usrdetails.selectGenderTitle();
		usrdetails.enterFirstName(excel.getStringData("LoginTestData", 1, 0));
		usrdetails.enterLastName(excel.getStringData("LoginTestData", 1, 1));
		usrdetails.enterPassword(excel.getStringData("LoginTestData", 1, 2));
		usrdetails.clickOnResisterbtn();
		logger.info("click on registr button");
		String Actualmessage=usrdetails.Sucessmsg();
		String Expected="Your account has been created.";
		Assert.assertEquals(Actualmessage, Expected);
		logger.info("Account Created Sucessfully");

		AddMyAdressPage adress=new AddMyAdressPage(driver);
		adress.ClickAddMyAdressLink();
		adress.enterAdress("pune");
		adress.enterCity("pune");
		logger.info("enter city");
		adress.selectState("Alabama");
		logger.info("select state");
		adress.zipcode("12345");
		logger.info("zipcode enter");
		adress.selectcountry1("United States");;
		logger.info("contry enter as UNITED STATE");
		adress.entermobnum1("9876566790");
		logger.info(excel.getStringData("LoginTestData", 1, 5));
		adress.savebtn();
		String Actualmessage1= adress.verifyAdress();
		String expectedm="Your addresses are listed below.";
		Assert.assertEquals(Actualmessage1, expectedm);
		logger.info("Your addresses are listed below.");
		captureScreenShot(driver, "verifylogin");
		}
	
	@Test
	public void verifyLogintest() throws InterruptedException 
	{
		driver.get(config.getAppURL());
		logger.info("url opened");
		IndexPage Inpage=new IndexPage(driver);
		Inpage.clickSignInLink();	
		AccountCreationDetailsPage act=new AccountCreationDetailsPage(driver);
		String str2= act.ResisteredEmailAdress(randomestring+"@gmail.com");
		System.out.println(str2+"patil2");
		act.registedpassword("1234567");
		
		Thread.sleep(5000);
		act.loginbtn();
	}
	
	
	
	
	
	
	
	
	
	
		 
		/*public String RandomNumber()
		{
			String generatedNumber= RandomStringUtils.randomNumeric(6);
			return generatedNumber;
		}
		public String RandomAlpha_Number()
		{
			String generatedNumber= RandomStringUtils.randomNumeric(3);
			String generatedstring= RandomStringUtils.randomAlphabetic(3);
			return (generatedNumber+"@"+generatedstring);
		}*/
	
		}
