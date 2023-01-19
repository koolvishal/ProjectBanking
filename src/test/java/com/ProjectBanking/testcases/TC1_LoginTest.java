package com.ProjectBanking.testcases;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ProjectBanking.pageobjects.Loginpage;
import com.ProjectBanking.utilities.XLUtils;


public class TC1_LoginTest extends BaseClass {
	
	@Test(dataProvider="loginData")
	public void Login(String uname,String pwd)
	{
		
		driver.get(baseURL);
		logger.info("URL is opened");
		driver.manage().window().maximize();
		logger.info("Window is maximized");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.setUsername(uname);
		logger.info("Entered Username");
		loginpage.setPassword(pwd);
		logger.info("Entered Password");
		loginpage.clicklogin();
		logger.info("Clicked on Login button");
		if(driver.getTitle().equalsIgnoreCase("GTPL Bank Manager HomePage"))
		{	Assert.assertTrue(true);
			logger.info("Test is Passed");
		}
		else
		{
			Assert.assertFalse(false);
			logger.info("Test is failed");
		}
		
	}
	
	
	@DataProvider(name="loginData")
	public String[][] getdata() throws IOException
	{
		String path = "./src\\test\\java\\com\\ProjectBanking\\testdata\\logintestData.xlsx";
		XLUtils xlutils = new XLUtils(path);
		
		int totalrowcount = xlutils.getRowCount("Sheet1");
		int totalcolcount = xlutils.getCellCount("Sheet1", 1);
		
		String loginData[][] = new String[totalrowcount][totalcolcount];
		
		for(int i=1;i<=totalrowcount;i++)
		{
			for(int j=0;j<totalcolcount;j++)
			{
				loginData[i-1][j]=xlutils.getCellData("Sheet1", i, j);
			}
			
		}
		
		return loginData;
		
	}
	
	
	
	
	
	
	
	
	

}
