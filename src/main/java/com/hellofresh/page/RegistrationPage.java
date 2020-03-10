package com.hellofresh.page;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hellofresh.utils.LOG;

public class RegistrationPage extends BasePage {

	WebDriver driver;
	String firstname, lastname;

	@FindBy(xpath = "//h3[contains(.,'Create an account')]")
	@CacheLookup
	public WebElement pageHeadingLogin;

	@FindBy(xpath = "//h1[contains(.,'Create an account')]")
	@CacheLookup
	public WebElement pageHeadingRegtn;

	@FindBy(id = "email_create")
	@CacheLookup
	public WebElement emailTextBox;

	@FindBy(id = "SubmitCreate")
	@CacheLookup
	public WebElement createAccntBtn;

	@FindBy(id = "id_gender1")
	@CacheLookup
	public WebElement maleUserTitleRadio;

	@FindBy(id = "id_gender2")
	@CacheLookup
	public WebElement femaleUserTitleRadio;

	@FindBy(id = "customer_firstname")
	@CacheLookup
	public WebElement userFirstNameTxtbox;

	@FindBy(id = "customer_lastname")
	@CacheLookup
	public WebElement userLastNameTxtbox;

	@FindBy(id = "passwd")
	@CacheLookup
	public WebElement userPasswordTxtbox;

	@FindBy(id = "days")
	@CacheLookup
	public WebElement userBirthDayDDN;

	@FindBy(id = "months")
	@CacheLookup
	public WebElement userBirthMonthDDN;

	@FindBy(id = "years")
	@CacheLookup
	public WebElement userBirthYearDDN;

	@FindBy(id = "company")
	@CacheLookup
	public WebElement userCompanyTxtbox;

	@FindBy(id = "address1")
	@CacheLookup
	public WebElement userAddress1Txtbox;

	@FindBy(id = "address2")
	@CacheLookup
	public WebElement userAddress2Txtbox;

	@FindBy(id = "city")
	@CacheLookup
	public WebElement userCityTxtbox;

	@FindBy(id = "id_state")
	@CacheLookup
	public WebElement userStateDDN;

	@FindBy(id = "postcode")
	@CacheLookup
	public WebElement userPostCodeTxtbox;

	@FindBy(id = "other")
	@CacheLookup
	public WebElement userAdditionalInfoTxtbox;

	@FindBy(id = "phone")
	@CacheLookup
	public WebElement userHomePhoneTxtbox;

	@FindBy(id = "phone_mobile")
	@CacheLookup
	public WebElement userMobilePhoneTxtbox;

	@FindBy(id = "alias")
	@CacheLookup
	public WebElement userAddressAliasTxtbox;

	@FindBy(id = "submitAccount")
	@CacheLookup
	public WebElement registerButton;

	@FindBy(xpath = "//a[@title='Log me out']")
	@CacheLookup
	public WebElement signOutBtn;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validateRegistrationPage() {
		waitForElement(pageHeadingRegtn);
	}

	public void enterRegistrationDetails(Map<Object, Object> data) {
		if (data.get("gender").toString().equalsIgnoreCase("female")) {
			waitAndClick(femaleUserTitleRadio);
		} else {
			waitAndClick(maleUserTitleRadio);
		}
		         waitAndWrite(userFirstNameTxtbox, data.get("firstname").toString())
				.waitAndWrite(userLastNameTxtbox, data.get("lastname").toString())
				.waitAndWrite(userPasswordTxtbox, data.get("password").toString())
				.selectByValue(userBirthDayDDN, data.get("day").toString())
				.selectByValue(userBirthMonthDDN, data.get("month").toString())
				.selectByValue(userBirthYearDDN, data.get("year").toString())
				.waitAndWrite(userCompanyTxtbox, data.get("company").toString())
				.waitAndWrite(userAddress1Txtbox, data.get("addressline1").toString())
				.waitAndWrite(userAddress2Txtbox, data.get("addressline2").toString())
				.waitAndWrite(userCityTxtbox, data.get("city").toString())
				.selectByVisibleText(userStateDDN, data.get("state").toString())
				.waitAndWrite(userPostCodeTxtbox, data.get("zipcode").toString())
				.waitAndWrite(userAdditionalInfoTxtbox, data.get("addninfo").toString())
				.waitAndWrite(userHomePhoneTxtbox, data.get("homephone").toString())
				.waitAndWrite(userMobilePhoneTxtbox, data.get("mobphone").toString())
				.waitAndWrite(userAddressAliasTxtbox, data.get("alias").toString()).waitAndClick(registerButton);
		this.firstname = data.get("firstname").toString();
		this.lastname = data.get("lastname").toString();
	}

	public void verifyRegistrationDetails() {
		By signOutBtn = By.xpath("//a[@title='Log me out']");
		if (isElementPresent(signOutBtn)) {
			LOG.info("LOGOUT button found after registering new user");
		} else {
			LOG.error("Error finding LOGOUT button after new user registration");
		}
		LoginPage loginPage = new LoginPage(driver);
		String actualname = loginPage.getAccntName();
		if (actualname.equalsIgnoreCase(firstname + " " + lastname)) {
			LOG.info("User name is displayed after login");
		} else {
			LOG.error("User name is not displayed as expcted after login");
			throw new AssertionError("Invalid user name displayed after login");
		}
	}

}
