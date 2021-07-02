package com.inetbank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver ldriver;

	public NewCustomerPage(WebDriver rdriver) {

		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement radioGender;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtDOB;
	
	
	@FindBy(how = How.NAME, using="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinNo;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtTelephoneNo;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmailID;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how = How.NAME, using="res")
	@CacheLookup
	WebElement btnReset;
	
	/*
	 * Confirm Customer Creation
	 * Use below Elements
	 */
	
	@FindBy(how = How.XPATH, using="//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
	@CacheLookup
	WebElement labCustomerID;
	
	@FindBy(how = How.XPATH, using="//a[contains(@href,\"Managerhomepage.php\") and contains(text(),\"Continue\")]")
	@CacheLookup
	WebElement lnkHomePage; 
	
	public void setCustomerName(String custName)
	{
		txtCustomerName.sendKeys(custName);
	}
	
	public void setGender()
	{
		radioGender.click();
	}
	
	public  void setDOB(String dd, String mm, String yyyy)
	{
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(yyyy);
	}
	
	public void setAddress(String addr)
	{
		txtAddress.sendKeys(addr);
	}
	
	public void setCity(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void setState(String state)
	{
		txtState.sendKeys(state);
	}
	
	public void setPIN(String pin)
	{
		txtPinNo.sendKeys(String.valueOf(pin));
	}
	
	public void setMobileNo(String mobileno)
	{
		txtTelephoneNo.sendKeys(mobileno);
	}
	
	public void setEmailID(String email)
	{
		txtEmailID.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public void clickReset()
	{
		btnReset.click();
	}	
	
	public String getCustID()
	{
		return labCustomerID.getText();
	}
	
	public void clickContinue()
	{
		lnkHomePage.click();
	}
	
}
