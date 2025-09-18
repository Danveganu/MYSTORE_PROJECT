package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddMyAdressPage {
	WebDriver ldriver;
	public AddMyAdressPage(WebDriver driver) {
		this.ldriver=driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath="//span[normalize-space()='Add my first address']")
	WebElement ClickAddMyAdressLink;

	@FindBy(xpath="//input[@id='address1']")
	WebElement enterAdress;
	@FindBy(xpath="//input[@id='city']")
	WebElement enterCity;
	@FindBy(xpath="//select[@id='id_state']")
	WebElement selectState;
	@FindBy(id="postcode")
	WebElement zipcode;
	@FindBy(id="id_country")
	WebElement selectcountry;
	@FindBy(id="phone_mobile")
	//input[@id='phone_mobile']
	WebElement entermobnum;
	@FindBy(id="alias")
	WebElement futurrefrance;
	@FindBy(id="submitAddress")
	WebElement savebtn;
	@FindBy(xpath="//strong[text()='Your addresses are listed below.']")
	WebElement Adreemessage;
	//strong[text()='Your addresses are listed below.']
	
	
	public void ClickAddMyAdressLink() {
		ClickAddMyAdressLink.click();
	}
	public void enterAdress(String Add) {
		enterAdress.sendKeys(Add);
	}
	public void enterCity(String city) {
		enterCity.sendKeys(city);
	}
	public void selectState(String state1) {
		Select state=new Select(selectState);
		state.selectByVisibleText(state1);
	
	}
	public void zipcode(String pin) {
		zipcode.sendKeys(pin);
	}
	public void selectcountry1(String country) {
		Select cont=new Select(selectcountry);
		cont.selectByVisibleText(country);
		
	}
	public void entermobnum1(String num) {
		entermobnum.sendKeys(num);
	}
	public void savebtn() {
		savebtn.click();
	}
	
	public String verifyAdress() {
		return Adreemessage.getText();
	}
	
}
