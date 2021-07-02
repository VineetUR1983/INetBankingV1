package com.inetbank.testCases;

import org.testng.annotations.Test;

import com.inetbank.pageObjects.EditCustomerPage;
import com.inetbank.pageObjects.HomePage;
import com.inetbank.pageObjects.LoginPage;

public class TC004_EditCustomer extends BaseClassTest {
	
	@Test
	public void editCustomer() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		
		
		lp.setUserName(username);
		logger.info("Provided Username");
		
		lp.setPassword(password);
		logger.info("Provided Password");
		
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		HomePage hp = new HomePage(driver);
		hp.clickEditCustomer();
		logger.info("Clicked Edit Customer from HomePage");
		
		EditCustomerPage ecp = new EditCustomerPage(driver);
		
		System.out.println("Value from Shared Class : " + SharedClass.getCustId());
		ecp.setCustomerId(SharedClass.getCustId());
		
		
		Thread.sleep(2000);
		ecp.clickSubmit();
		
		Thread.sleep(3000);
	}

}
