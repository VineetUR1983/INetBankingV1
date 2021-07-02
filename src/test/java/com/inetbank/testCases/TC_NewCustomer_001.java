package com.inetbank.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbank.pageObjects.LoginPage;
import com.inetbank.pageObjects.NewCustomerPage;
import com.inetbank.pageObjects.HomePage;

import java.io.IOException;


public class TC_NewCustomer_001 extends BaseClassTest{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		
		
		lp.setUserName(username);
		logger.info("Provided Username");
		
		lp.setPassword(password);
		logger.info("Provided Password");
		
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		HomePage hp = new HomePage(driver);
		hp.clickNewCustomer();
		logger.info("Click New Customer from HomePage");
		
		//Thread.sleep(3000);
		
		
		logger.info("Enter details for New Customer");
		NewCustomerPage newCust = new NewCustomerPage(driver);
		String customerName = randomString(10);
		newCust.setCustomerName(customerName);
		newCust.setGender();
		newCust.setDOB("08", "04", "1986");
		newCust.setAddress("HobliAve");
		newCust.setCity("Sokyo");
		newCust.setState("Alabama");
		newCust.setPIN("110021");
		newCust.setMobileNo("777777777");
		
		String email_Id = randomString(8) + "@gmails.com";
		newCust.setEmailID(email_Id);
		
		newCust.setPassword("test123");
		newCust.clickSubmit();
		//Thread.sleep(5000);
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result==true)
		{
			Assert.assertTrue(true);
			logger.info("Created New Customer");
			
			logger.info("Customer ID : " + newCust.getCustID());
			
			SharedClass.setCustId(newCust.getCustID());
			
			newCust.clickContinue();
			logger.info("Clicked on Continue to Navigate to HomePage");
			hp.clickLogout();
			logger.info("Returned to Login Page");
			
		} else
		{
			captureScreen(driver,"AddNewCustomer");
			logger.error("Failed to Created New Customer details");
			Assert.assertTrue(false);
		}
		
	}

}
