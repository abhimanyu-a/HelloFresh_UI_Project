package com.hellofresh.utils;

import org.apache.log4j.Logger;

public class LOG {

	// Initialize Log4j logs

	private static Logger LOG = Logger.getLogger(LOG.class.getName());//

	// This is to print log for the beginning of the test case, as we usually run so
	// many test cases as a test suite

	public static void startTestCase(String testName) {

		LOG.info("Starting " + testName);
	}

	// This is to print log for the ending of the test case

	public static void endTestCase(String testName) {

		LOG.info("Execution of Test Case " + testName + " is complete");

	}

	// Need to create these methods, so that they can be called

	public static void info(String message) {

		LOG.info(message);
	}

	public static void warn(String message) {

		LOG.warn(message);

	}

	public static void error(String message) {

		LOG.error(message);

	}

	public static void fatal(String message) {

		LOG.fatal(message);

	}

	public static void debug(String message) {

		LOG.debug(message);

	}

}