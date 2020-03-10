package com.hellofresh.utils;

import java.util.Date;

public class RandomUtil {
	
	public static String createRandomEmailAddress()
	{
		String timestamp = String.valueOf(new Date().getTime());
		String email = "hf_challenge" + timestamp + "@hf" + timestamp.substring(7) + ".com";
		
		return email;
	}

}
