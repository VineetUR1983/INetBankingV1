package com.inetbank.testCases;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbank.pageObjects.HomePage;
import com.inetbank.pageObjects.LoginPage;
import com.inetbank.utilities.XLUtils;

public class TC_LoginTestDDT_002 extends BaseClassTest {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String userName, String passWord) throws InterruptedException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Username has been Entered");
		lp.setPassword(passWord);
		logger.info("Password has been Entered");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			Thread.sleep(3000);
			captureScreen(driver,"LoginTest");	
			driver.switchTo().alert().accept();
			logger.info("Alert Message has been Accepted and Closed");
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed : For User - > " + userName + " and Password - > " + passWord);
			
		} else
		{
			Thread.sleep(3000);
			Assert.assertTrue(true);
			logger.warn("Login Passed : For User - > " + userName + " and Password - > " + passWord);
			HomePage hp = new HomePage(driver);
			hp.clickLogout();
			logger.warn("User Clicked on Logout Link");
			driver.switchTo().alert().accept(); // Close Alert on Logout
			driver.switchTo().defaultContent();
			
		}
		
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		// Create 2D Array to Replicate the Data in Excel Sheet for Login Data 5 Rows , 2 Columns

		String xlPath = System.getProperty("user.dir")+ "\\src\\test\\java\\com\\inetbank\\testData\\LoginTestData.xlsx";
		System.out.println(xlPath);
		String xlSheetName = "LoginData";
		
		int rowNum = XLUtils.getRowCount(xlPath, xlSheetName);
		int colNum = XLUtils.getCellCount(xlPath, xlSheetName, rowNum);
		
		String loginData[][] =new String[rowNum][colNum];
		
		for(int i=1; i <= rowNum; i++)
		{
			for(int j = 0; j < colNum; j++)
			{
				loginData[i - 1][j]= XLUtils.getCellData(xlPath, xlSheetName, i, j);
				
			}
		}
		System.out.println("String Array for LoginData formed");
		System.out.println(Arrays.deepToString(loginData));
		
		
		return loginData;
	}

}
