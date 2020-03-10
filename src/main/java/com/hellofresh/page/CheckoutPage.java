package com.hellofresh.page;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hellofresh.utils.LOG;
import com.hellofresh.utils.PaymentType;

public class CheckoutPage extends BasePage {

	WebDriver driver;
	String productName, color, size;
	int quantity;

	@FindBy(id = "group_1")
	@CacheLookup
	public WebElement productSize;

	@FindBy(xpath = "//a[@title='Contact Us']")
	@CacheLookup
	public WebElement contactUs;

	@FindBy(xpath = "//i[@class='icon-plus']")
	@CacheLookup
	public WebElement iconPlus;

	@FindBy(id = "selectProductSort")
	@CacheLookup
	public WebElement productSort;

	@FindBy(name = "Submit")
	@CacheLookup
	public WebElement productAdd;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	@CacheLookup
	public WebElement productCheckout;

	@FindBy(css = "td.cart_description > p.product-name")
	@CacheLookup
	public WebElement productNamelabel;

	@FindBy(css = "td.cart_total > span.price")
	@CacheLookup
	public WebElement productPriceLabel;

	@FindBy(css = "input.grey[name^='quantity_']")
	public WebElement productQuantityTxtbox;

	@FindBy(css = "td.cart_description > p.product-name")
	@CacheLookup
	public WebElement paymentPageProductNamelabel;

	@FindBy(css = "td.cart_total > span.price")
	@CacheLookup
	public WebElement paymentPageProductPriceLabel;

	@FindBy(css = "td.cart_quantity > span")
	@CacheLookup
	public WebElement paymentPageProductQuantityTxtbox;

	@FindBy(css = "a.standard-checkout[title='Proceed to checkout']")
	@CacheLookup
	public WebElement proceedToCheckout;

	@FindBy(xpath = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
	@CacheLookup
	public WebElement cartProceedToCheckout;

	@FindBy(name = "processAddress")
	public WebElement cartProcssAddressProceedToCheckout;

	@FindBy(name = "processCarrier")
	public WebElement cartProcessCarrierProceedToCheckout;

	@FindBy(className = "bankwire")
	@CacheLookup
	public WebElement bankwirePaymentMode;

	@FindBy(className = "cheque")
	@CacheLookup
	public WebElement checkPaymentMode;

	@FindBy(xpath = "//button//span[text()='I confirm my order']")
	@CacheLookup
	public WebElement confirmOrderBtn;

	@FindBy(css = "h1")
	@CacheLookup
	public WebElement orderConfirmationHeader;

	@FindBy(css = "li.step_current")
	public WebElement currentStepTitle;

	@FindBy(id = "address_delivery")
	@CacheLookup
	public WebElement deliveryAddress;

	@FindBy(id = "address_invoice")
	@CacheLookup
	public WebElement billingAddress;

	@FindBy(css = "p.carrier_title")
	@CacheLookup
	public WebElement chooseShippingAddressLabel;

	@FindBy(xpath = "//li[@class='step_done step_done_last four']")
	@CacheLookup
	public WebElement shippingStepTitle;

	@FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
	@CacheLookup
	public WebElement paymentStepTitle;

	@FindBy(id = "uniform-cgv")
	@CacheLookup
	public WebElement checkboxTnC;

	@FindBy(xpath = "//*[@class='cheque-indent']/strong")
	@CacheLookup
	public WebElement orderCompletionLabel;

	@FindBy(xpath = "//td[@class='cart_description']//small[2]//a")
	@CacheLookup
	public WebElement cartDescription;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectShoppingType(String selectType) {

		waitForElement(contactUs);
		driver.findElement(By.xpath("//a[@title='" + selectType + "']")).click();
	}

	public void addProductToCart(Map<Object, Object> data) {
		productName = data.get("productname").toString();
		size = data.get("size").toString();
		color = data.get("color").toString();
		quantity = Integer.parseInt(data.get("quantity").toString());

		waitForVisibiityClick(data.get("productname").toString()).selectByVisibleText(productSize,
				data.get("size").toString());

		WebElement productColor = driver.findElement(By.xpath("//a[@title='" + data.get("color").toString() + "']"));
		waitAndClick(productColor);
		// Below log iterates the click again to add quantity
		for (int i = 0; i < quantity - 1; i++) {
			waitAndClick(iconPlus);
		}
		waitAndClick(productAdd).waitAndClick(productCheckout);
	}

	public boolean verifyAddedProduct() {
		try {
			waitForVisibiity(productName);
			LOG.info(" The product " + productName + " has been successfully added to cart");
			return true;
		} catch (Exception e) {
			LOG.error(" The product " + productName + " is not available in cart: " + e.toString());
		}
		return false;
	}

	public void verifyAllDetailsInCart() {
		try {
			waitForElement(cartDescription);
			String itemDesc = cartDescription.getText();
			if (itemDesc.contains(size) && itemDesc.contains(color) && itemDesc.contains(String.valueOf(quantity))) {
				LOG.info("Before payment, all the details of the product: " + productName + " , quantity: " + quantity
						+ " , size: " + size + "and color: " + color + "  has been validated");
			}
		} catch (Exception e) {
			LOG.error("Mismatch in either product color, quantity or size: " + e.toString());
		}
	}

	public void verifyShipping() {
		waitAndClick(checkboxTnC).waitAndClick(cartProcessCarrierProceedToCheckout);
	}

	public void makePayment(String paymentType) {
		waitForVisibiity(productName);
		if (paymentType.equalsIgnoreCase(PaymentType.Bankwire.toString())) {
			LOG.info("User has opted for payment type -Bankwire");
			waitAndClick(bankwirePaymentMode);
		} else if (paymentType.equalsIgnoreCase(PaymentType.Check.toString())) {
			LOG.info("User has opted for payment type - Check ");
			waitAndClick(checkPaymentMode);
		}
	}
}
