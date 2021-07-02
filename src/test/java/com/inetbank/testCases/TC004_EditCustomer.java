package com.inetbank.testCases;

import org.testng.annotations.Test;

import com.inetbank.pageObjects.EditCustomerPage;

public class TC004_EditCustomer extends BaseClassTest {
	
	
	
	@Test
	public void editCustomer() throws InterruptedException
	{
		BaseClassTest b = new BaseClassTest();
		EditCustomerPage ecp = new EditCustomerPage(driver);
		ecp.setCustomerId(b.custId);
		Thread.sleep(2000);
		ecp.clickSubmit();
	}

}
