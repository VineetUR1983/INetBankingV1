package com.inetbank.testCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbank.utilities.ReadConfig;





public class BaseClassTest {
	
	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	public String custId = "";
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		if(br.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();	
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readConfig.getFireFoxPath());
			driver = new FirefoxDriver();	
		} else if(br.equalsIgnoreCase("iexplorer"))
		{
			System.setProperty("webdriver.ie.driver", readConfig.getIExplorerPath());
			driver = new InternetExplorerDriver();	
		}
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get(baseURL);
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
		
	}
	
	public String randomString(int charNos)
	{
		String randString = RandomStringUtils.randomAlphabetic(charNos);
		return randString;
		
	}
	
	public String randomNumber(int nosDigits)
	{
		String randNumber = RandomStringUtils.randomNumeric(nosDigits);
		return randNumber;
		
	}
	
	
}
