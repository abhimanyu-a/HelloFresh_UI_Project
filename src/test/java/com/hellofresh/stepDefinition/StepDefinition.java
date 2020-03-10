package com.hellofresh.stepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import com.hellofresh.drivermanagement.DriverManager;
import com.hellofresh.drivermanagement.DriverManagerFactory;
import com.hellofresh.page.CheckoutPage;
import com.hellofresh.page.LoginPage;
import com.hellofresh.page.RegistrationPage;
import com.hellofresh.utils.LOG;
import com.hellofresh.utils.PropertyUtils;
import com.hellofresh.utils.RandomUtil;
import com.hellofresh.utils.ScreenshotUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	LoginPage loginPage;
	RegistrationPage regPage;
	DriverManager driverManager;
	CheckoutPage checkoutPage;
	WebDriver driver;
	List<Map<Object, Object>> userData;
	List<Map<Object, Object>> prodData;

	private static final PropertyUtils propertyUtils = new PropertyUtils();

	@Before
	public void beforeTest(Scenario sname) throws IOException {

		LOG.info("Starting test sceanrio: " + sname.getName());
		driverManager = DriverManagerFactory.getManager();
		driver = driverManager.getDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		regPage = new RegistrationPage(driver);
		checkoutPage = new CheckoutPage(driver);
	}

	@AfterMethod
	public void afterMethod(Scenario sname) throws IOException {
		if (sname.isFailed()) {
			ScreenshotUtil.takeScreenshot(driver);
		}
	}

	@After
	public void afterTest(Scenario sname) {
		LOG.info("Completed executing test sceanrio: " + sname.getName());
		driverManager.quitDriver();
	}

	@Given("User Navigates to {string} website URL")
	public void user_Navigates_to_website(String appName) throws IOException {
		try {
			driver.navigate().to(propertyUtils.getProperty("URL"));
			LOG.info("Launching " + appName + " website");
		} catch (IOException e) {
			e.printStackTrace();
			LOG.error("Unable to read config property file");
		}
	}

	@Then("User clicks on SignIn button in Home page")
	public void user_clicks_on_sign_in_button_from_home_page() throws IOException {
		loginPage.loginBtn.click();
		LOG.info("User clicks on Sign-in button in the Home Page");
	}

	@When("User provides credentials for {string} and {string}")
	public void user_provides_valid_credentials_for_and(String userName, String password) {

		loginPage.waitAndWrite(loginPage.emailTxtbox, userName).waitAndWrite(loginPage.passwordTxtbox, password);

		LOG.info("Login credentials provided");
	}

	@Then("User clicks on SignIn button in Login page")
	public void user_clicks_on_sign_in_button_from_login_page() {

		loginPage.waitAndClick(loginPage.loginSubmit);
		LOG.info("User clicks on Sign-in in the Login Page");
	}

	@Then("Verify user is loggedIn as {string}")
	public void verify_user_is_loggedIn_as(String expectedName) throws IOException {

		String actualName = loginPage.getAccntName();
		Assert.assertEquals("User name should be displayed after login", expectedName, actualName);
		LOG.info("User details after login verfied - They match");
		try {
			Assert.assertEquals("The URL's should match", propertyUtils.getProperty("SUMMARY_PAGE_URL"),
					driver.getCurrentUrl());
		} catch (IOException e) {
			LOG.error("Unable to read Config Property file: " + e.toString());
		}
	}

	@Then("Verify user is shown an error message\"")
	public void verify_user_is_shown_an_error_message() {
		loginPage.waitAndClick(loginPage.errorMessageBox);
		LOG.info("User is logging in with invalid credentials");
		LOG.info("User is displayed an error message:" + loginPage.errorMessageBox.getText());
	}

	@When("User provides valid emailId for account creation")
	public void user_provides_valid_emailId_for_account_creation() {
		String email = RandomUtil.createRandomEmailAddress();
		try {
			regPage.waitForElement(regPage.pageHeadingLogin).waitAndWrite(regPage.emailTextBox, email);
		}

		catch (Exception e) {
			LOG.error("Unable to create account for email: " + email);
		}
	}

	@Then("User clicks on Create An Account button")
	public void user_clicks_on_Create_An_Account_button() {
		regPage.waitAndClick(regPage.createAccntBtn);
		LOG.info("User clicks on Account registration butoon");
	}

	@Then("Verify user is present on Registartion page")
	public void verify_user_is_present_on_Registartion_page() {
		try {
			regPage.validateRegistrationPage();
			Assert.assertEquals("The URL's should match", propertyUtils.getProperty("REGISTRATION_PAGE"),
					driver.getCurrentUrl());
		} catch (IOException e) {
			LOG.error("Unable to read Config Property file: " + e.toString());
		}
	}

	@When("User fills Registration form with valid details")
	public void user_fills_Registration_form_with_valid_details(DataTable dataTable) {
		userData = dataTable.asMaps(String.class, String.class);
		for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {

			regPage.enterRegistrationDetails(data);

		}
		LOG.info("User has filled registration form with valid details");
	}

	@Then("Verify user was created successfully")
	public void verify_user_was_created_successfully() {
		try {
			Assert.assertEquals("Asserting new user registration URL's: ",
					propertyUtils.getProperty("SUMMARY_PAGE_URL"), driver.getCurrentUrl());
		} catch (IOException e) {
			LOG.error("Unable to read Config Property file: " + e.toString());
		}
	}

	@Then("User name and logout button was displayed correctly")
	public void user_name_and_logout_button_was_displayed_correctly() {
		try {
			regPage.verifyRegistrationDetails();
			LOG.info("Logout button found");
		} catch (Exception e) {
			LOG.error("Unable to find LOGOUT button: " + e.toString());
		}
	}

	@When("User clicks on {string} section link")
	public void user_clicks_on_section_link(String option) {
		try {
			checkoutPage.selectShoppingType(option);
			LOG.info("User has selected the shopping preference: " + option);
		} catch (Exception e) {
			LOG.error("Unable to select the option: " + option + " " + e.toString());
		}

	}

	@When("User selects a product and adds it to cart")
	public void user_selects_a_product_and_adds_it_to_cart(DataTable dataTable) {

		try {
			prodData = dataTable.asMaps(String.class, String.class);
			for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {

				checkoutPage.addProductToCart(data);
			}
			LOG.info("Product added to cart");
		} catch (Exception e) {
			LOG.error("Product not  found");
		}

	}

	@Then("Verify product has been added to cart")
	public void verify_product_has_been_added_to_cart() {

		Assert.assertTrue("Verifying product is present in cart: ", checkoutPage.verifyAddedProduct());
	}

	@When("User clicks on Proceed to checkout")
	public void user_clicks_on() {
		try {
			checkoutPage.waitAndClick(checkoutPage.cartProceedToCheckout);
			LOG.info("User is able to procced to checkout");
		} catch (Exception e) {
			LOG.error("Error proceeding to checkout: " + e.toString());
		}
	}

	@Then("Verify cart product details and proceed")
	public void verify_cart_product_details_and_proceed() {
		checkoutPage.verifyAllDetailsInCart();
	}

	@Then("Verify address and proceed")
	public void verify_address_and_proceed() {

		// verify address details are present
		Assert.assertTrue("Delivery address not found", checkoutPage.deliveryAddress.isDisplayed());
		Assert.assertTrue("Billing address not found", checkoutPage.billingAddress.isDisplayed());
		checkoutPage.waitAndClick(checkoutPage.cartProcssAddressProceedToCheckout);
	}

	@Then("Verify shipping and proceed")
	public void verify_shipping_and_proceed() {

		checkoutPage.waitAndClick(checkoutPage.chooseShippingAddressLabel);
		Assert.assertTrue("Title does-not match", checkoutPage.currentStepTitle.getText().contains("Shipping"));

		checkoutPage.waitAndClick(checkoutPage.checkboxTnC);

		LOG.info("Shipping selection complete");
		checkoutPage.waitAndClick(checkoutPage.cartProcessCarrierProceedToCheckout);
	}

	@When("User selects {string} payment method")
	public void user_selects_payment_method(String paymentType) {
		checkoutPage.makePayment(paymentType);
		LOG.info("Payment selection complete");
	}

	@When("User confirms the order")
	public void user_confirms_the_order() {
		checkoutPage.waitAndClick(checkoutPage.confirmOrderBtn);
	}

	@Then("Verify order completion details")
	public void verify_order_completion_details() {
		checkoutPage.waitAndClick(checkoutPage.orderConfirmationHeader);
		Assert.assertTrue("Title does-not match", checkoutPage.currentStepTitle.getText().contains("Payment"));


		Assert.assertEquals("Text do-not match", checkoutPage.orderConfirmationHeader.getText(), "ORDER CONFIRMATION");

		Assert.assertTrue("Shipping Step is not present as fourth step", checkoutPage.shippingStepTitle.isDisplayed());
		Assert.assertTrue("Payment Step is not present as current step", checkoutPage.paymentStepTitle.isDisplayed());

		Assert.assertEquals("Order completion confirmation message does-not match",
				checkoutPage.orderCompletionLabel.getText(), "Your order on My Store is complete.");

		Assert.assertTrue("Order confirmation page - URL Addres does-not match",
				driver.getCurrentUrl().contains("controller=order-confirmation"));

		LOG.info("Order completion details verified");
	}

}
