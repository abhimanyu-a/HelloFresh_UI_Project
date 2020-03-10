package com.hellofresh.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

	WebDriver driver;

	@FindBy(className = "login")
	public WebElement loginBtn;

	@FindBy(id = "email_create")
	public WebElement registerUserEmailTxtbox;

	@FindBy(id = "email")
	public WebElement emailTxtbox;

	@FindBy(id = "passwd")
	public WebElement passwordTxtbox;

	@FindBy(css = "div.alert.alert-danger")
	public WebElement errorMessageBox;

	@FindBy(id = "SubmitCreate")
	public WebElement createAnAccountBtn;

	@FindBy(id = "SubmitLogin")
	public WebElement loginSubmit;
	
	@FindBy(xpath = "//a[@class='account']//span")
	public WebElement userAccntName;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getAccntName()
	{
		return(userAccntName.getText());
	}

}
