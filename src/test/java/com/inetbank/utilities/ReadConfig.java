package com.inetbank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties confProps;

	public ReadConfig()
	{

		File confFile = new File("./Configuration/config.properties");

		try 
		{
			FileInputStream fis = new FileInputStream(confFile);
			confProps = new Properties();
			confProps.load(fis);
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Excpetion is " + e.getMessage());
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Excpetion is " + e.getMessage());
		}

	}
	
	public String getApplicationURL()
	{
		String baseURL = confProps.getProperty("baseURL");
		return baseURL;
		
	}
	
	public String getUserName()
	{
		String userName = confProps.getProperty("username");
		return userName;
	}
	
	public String getPassword()
	{
		String password = confProps.getProperty("password");
		return password;
	}

	public String getChromePath()
	{
		String chromePath = confProps.getProperty("path_chromedriver");
		return chromePath;
	}
	
	public String getFireFoxPath()
	{
		String fireFoxPath = confProps.getProperty("path_firefoxdriver");
		return fireFoxPath;
	}
	
	public String getIExplorerPath()
	{
		String iExplorerPath = confProps.getProperty("path_IEdriver");
		return iExplorerPath;
	}


}
