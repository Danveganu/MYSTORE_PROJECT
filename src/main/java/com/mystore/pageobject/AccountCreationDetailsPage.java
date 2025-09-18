package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationDetailsPage {

	WebDriver ldriver;
	public AccountCreationDetailsPage(WebDriver driver) {
		this.ldriver=driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(id="id_gender1")
	WebElement titlemr;

	@FindBy(id="customer_firstname")
	WebElement firstName;
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement LastName;
	@FindBy(xpath="//input[@id='passwd']")
	WebElement Pass;

	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement registerbtn;
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement sucessmsg;
	@FindBy(xpath="//input[@id='passwd']")
	WebElement ResisteredEmailAdress;
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	@FindBy(xpath="//span[normalize-space()='Sign in']")
	WebElement loginbtn;

	public void selectGenderTitle() {
		titlemr.click();
		}
	public void enterFirstName(String Fname) {
		firstName.sendKeys(Fname);
		}
	public void enterLastName(String Lname) {
		LastName.sendKeys(Lname);
		}
	public String enterPassword(String pass) {
		Pass.sendKeys(pass);
		return pass;
		}
	public void clickOnResisterbtn() {
		registerbtn.click();
        }
	public String Sucessmsg() {
		String confimatonmsg=sucessmsg.getText();
		return confimatonmsg;
        }
	public String ResisteredEmailAdress(String Registeremail) {
		ResisteredEmailAdress.sendKeys(Registeremail);
		return Registeremail;
		}
	public void registedpassword (String passwrd) {
		password.sendKeys(passwrd);
		}
	public void loginbtn() {
		loginbtn.click();
		}
	
}
