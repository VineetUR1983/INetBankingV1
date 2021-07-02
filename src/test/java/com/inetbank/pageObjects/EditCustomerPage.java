package com.inetbank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver ldriver;
	
	public EditCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@name='cusid']")
	@CacheLookup
	WebElement txtCustomerId;
	
	@FindBy(xpath="//input[@type='submit'][@name='AccSubmit']")
	@CacheLookup
	WebElement btnCustIdSumbit;
	
	@FindBy(xpath="//input[@type='reset'][@name='res']")
	@CacheLookup
	WebElement btnCustIdReset;
	
	/**
	 * 
	 * @param custId
	 * Provide the CustomerId that was generated which registering the selected Customer using CustomerPageObject 
	 * @return void
	 */
	public void setCustomerId(String custId)
	{
		txtCustomerId.sendKeys(custId);
	}
	
	public void clickSubmit()
	{
		btnCustIdSumbit.click();
	}
	
	public void clickReset()
	{
		btnCustIdReset.click();
	}	

}
