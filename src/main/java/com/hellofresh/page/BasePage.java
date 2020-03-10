package com.hellofresh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.utils.LOG;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	public boolean isElementPresent(By by) {
		if (driver.findElements(by).size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public BasePage waitForElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			LOG.error("Unable to find element: " + e.toString());
		}
		return this;
	}
	
	public BasePage waitForVisibiity(String name) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(name)));
		} catch (NoSuchElementException e) {
			LOG.error("Unable to find element: " + e.toString());
		}
		return this;
	}

	public BasePage waitForVisibiityClick(String name) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(name))).click();
		} catch (NoSuchElementException e) {
			LOG.error("Unable to find element: " + e.toString());
		}
		return this;
	}

	public BasePage waitAndClick(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (NoSuchElementException e) {
			LOG.error("Unable to find element: " + e.toString());
		}
		return this;
	}

	public BasePage waitAndClick(By element) {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}
		catch (NoSuchElementException e) {
			LOG.error("Unable to find element: " + e.toString());
		}

		return this;
	}
	

	public BasePage waitAndWrite(WebElement element, String text) {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
		}
		catch (NoSuchElementException e) {
			LOG.error("Unable to find element: " + e.toString());
		}

		return this;
	}

	public BasePage waitAndWrite(By element, String text) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
		} catch (NoSuchElementException e) {
			LOG.error("Unable to find element: " + e.toString());
		}
		return this;
	}

	public BasePage waitAndWrite(By element, Keys key) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(key);
		} catch (NoSuchElementException e) {
			LOG.error("Unable to find element: " + e.toString());
		}
		return this;
	}

	public BasePage selectByVisibleText(WebElement element, String text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			LOG.error("Unable to find element: " + e.toString());
		}
		return this;
	}

	public BasePage selectById(WebElement element, int id) {
		try {
			Select select = new Select(element);
			select.selectByIndex(id);
		} catch (NoSuchElementException e) {
			LOG.error("Unable to find element: " + e.toString());
		}
		return this;
	}

	public BasePage selectByValue(WebElement element, String val) {
		try {
			Select select = new Select(element);
			select.selectByValue(val);
		} catch (NoSuchElementException e) {
			LOG.error("Unable to find element: " + e.toString());
		}
		return this;
	}

}