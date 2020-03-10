package com.hellofresh.drivermanagement;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.hellofresh.utils.LOG;
import com.hellofresh.utils.PropertyUtils;

public class DriverManagerFactory {
	static PropertyUtils configProperty = new PropertyUtils();

	public static DriverManager getManager() {

		DriverManager driverManager = null;
		
		try {
			if(configProperty.getProperty("BROWSER").toString().toLowerCase().equalsIgnoreCase("chrome"))
			{
				driverManager = new ChromeDriverManager();
				LOG.info("Test execution in CHROME browser");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driverManager;

	}
}