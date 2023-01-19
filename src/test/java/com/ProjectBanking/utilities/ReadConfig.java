package com.ProjectBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties props;
	
	public ReadConfig() 
	{
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			props = new Properties();
			props.load(fis);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public String getURL()
	{
		String url=props.getProperty("baseURL");
	
		return url;
	}
	
	public String getUsername()
	{
		String username=props.getProperty("username");
	
		return username;
	}
	
	public String getPassword()
	{
		String password=props.getProperty("password");
	
		return password;
	}
	
	public String getchromeDriver()
	{
		String chromepath=props.getProperty("chromepath");
	
		return chromepath;
	}
	
	public String getedgeDriver()
	{
		String chromepath=props.getProperty("edgepath");
	
		return chromepath;
	}
	
}
