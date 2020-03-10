package com.hellofresh.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	WebDriver driver;
	private final static String SSHOT_PATH = System.getProperty("user.dir") + "\\Screenshots\\";

	public static void takeScreenshot(WebDriver driver) throws IOException {

		Date d = new Date();
		System.out.println(d.toString());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(SSHOT_PATH + sdf.format(d) + "//" + sdf.format(d) + ".png"));
	}
}
