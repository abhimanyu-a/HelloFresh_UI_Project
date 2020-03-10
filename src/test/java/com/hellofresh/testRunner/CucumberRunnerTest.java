package com.hellofresh.testRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/feature"},
		glue = {"com.hellofresh.stepDefinition"},
		plugin = { "pretty", "html:target/report/html", "json:target/report/json/result.json"},
		dryRun = false,
		strict = true,
		monochrome = true
)
public class CucumberRunnerTest {

	@AfterClass
	public static void writeExtentReport()
	{
	
}
}
