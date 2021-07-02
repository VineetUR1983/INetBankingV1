package com.inetbank.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbank.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClassTest {
	
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("Accessing Base URL");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered UserName");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickLogin();
		logger.info("User Clicked on Login Button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Home Page Title Assertion Passed");
		}
		else
		{
			captureScreen(driver,"LoginTest");			
			Assert.assertTrue(false);
			logger.warn("Home Page Title Assertion Failed");
		}
		
	}
		

}
