package com.mystore.testcase;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.Utility.BaseClass;
import com.mystore.pageobject.AccountCreationDetailsPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccountPage;

public class TC_AccountCreationDetailsTest extends BaseClass {
	
	@Test
	public void accountDetails() {
		
		driver.get(config.getAppURL());
		logger.info("url opened");
		
		IndexPage Inpage=new IndexPage(driver);
		Inpage.clickSignInLink();
		
		MyAccountPage myaccPage=new MyAccountPage(driver);
		myaccPage.enterEmailAdress(RandomString()+"@gmail.com");
		myaccPage.clickSubmitCreate();
		logger.info("Click On Account Create Button");
		
		String Actualurl=driver.getCurrentUrl();
		String expectedurl="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
		Assert.assertEquals(Actualurl, expectedurl);
		logger.info("we are on correct url now");
		
		
		
		AccountCreationDetailsPage usrdetails=new AccountCreationDetailsPage(driver);
		usrdetails.selectGenderTitle();
		usrdetails.enterFirstName("jategaon");
		usrdetails.enterLastName("patil");
		usrdetails.enterPassword("1234567");
		usrdetails.clickOnResisterbtn();
		
	}
	
	
	
	
	
	public String RandomString()
  {
  	String generatedstring= RandomStringUtils.randomAlphabetic(6);
		return generatedstring;
  }	
	 public String RandomNumber()
     {
     	String generatedNumber= RandomStringUtils.randomNumeric(6);
			return generatedNumber;
 	 }
     public String RandomAlpha_Number()
     {
     	String generatedNumber= RandomStringUtils.randomNumeric(3);
     	String generatedstring= RandomStringUtils.randomAlphabetic(3);
			return (generatedNumber+"@"+generatedstring);
     }
}
