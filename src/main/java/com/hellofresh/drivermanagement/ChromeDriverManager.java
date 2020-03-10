package com.hellofresh.drivermanagement;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.utils.LOG;
import com.hellofresh.utils.PropertyUtils;

public class ChromeDriverManager extends DriverManager {

	private ChromeDriverService chService;
	static PropertyUtils configProperty = new PropertyUtils();
	WebDriverWait wait;

	@Override
	public void stopService() {
		if (null != chService && chService.isRunning())
			chService.stop();
	}

	@Override
	public void createDriver() {
		try {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + configProperty.getProperty("CHROME_EXECUTBALE_PATH"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		LOG.info("Unable to read Config file: " +e1.toString());
		}
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		{
			try {
			if (configProperty.getProperty("BROWSER_BEHAVIOUR").toString().toLowerCase().equalsIgnoreCase("headless")) {
					options.addArguments("-headless");
					LOG.info("Chrome Browser launched in HEADLESS mode");
				}
			else if (configProperty.getProperty("BROWSER_BEHAVIOUR").toString().toLowerCase().equalsIgnoreCase("incognito")) {
					options.addArguments("--incognito");
					LOG.info("Chrome Browser launched in INCOGNITO mode");
				}
			} catch (IOException e) {
				LOG.error("Unable to read config file: "+e.toString());
			}
			options.addArguments("test-type");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);
			driver = new ChromeDriver(options);
			try {
				wait = new WebDriverWait(driver, Integer.parseInt(configProperty.getProperty("WAIT_TIME").toString()));
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				LOG.error("Unable to read config file: "+e.toString());
			}
		}
	}

}