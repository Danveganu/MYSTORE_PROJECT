package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage  {


	WebDriver ldriver;

	public IndexPage(WebDriver driver) {
		this.ldriver=driver;
		PageFactory.initElements(driver, this);
	}

	//Identification of webelement
	@FindBy(xpath="//a[normalize-space()='Sign in']")
	WebElement signInLink;

	//action on webelement
	public void clickSignInLink() {
		signInLink.click();
		//String expectedURL=driver.getCurrentUrl();
		//Assert.assertEquals(true, signInLink);


	}}
