package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Utility.BaseClass;

public class MyAccountPage extends BaseClass {

	WebDriver ldriver;
	public MyAccountPage(WebDriver rdriver) {
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Identification of webelement
		@FindBy(xpath="//input[@id='email_create']")
		WebElement createEmailId;

		@FindBy(xpath="//button[@id='SubmitCreate']")
		WebElement submitcreate;




		//action on webelement
		public String enterEmailAdress(String email) {
			
			createEmailId.sendKeys(email);
			return email;
			
		}


		public void clickSubmitCreate() {
				submitcreate.click();

		}


        }
