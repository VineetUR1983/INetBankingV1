package com.inetbank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver ldriver;

	public HomePage(WebDriver rdriver) {

		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(xpath="//a[contains(@href, 'Logout.php')]")
	@CacheLookup
	WebElement lnkLogout;
	
	@FindBy(xpath = "//a[contains(@href,'addcustomerpage.php')]")
	@CacheLookup
	WebElement lnkNewCustomer;
	
	@FindBy(xpath = "//a[contains(@href,'EditCustomer.php')]")
	@CacheLookup
	WebElement lnkEditCustomer;
	
	public void clickNewCustomer()
	{
		lnkNewCustomer.click();
	}
	
	public void clickEditCustomer()
	{
		lnkEditCustomer.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
		ldriver.switchTo().alert().accept();
		
	}


}
