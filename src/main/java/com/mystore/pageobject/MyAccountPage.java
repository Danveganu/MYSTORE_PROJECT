package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

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
		public void enterEmailAdress(String email) {
			createEmailId.sendKeys(email);
		}


		public void clickSubmitCreate() {
				submitcreate.click();

		}


        }
