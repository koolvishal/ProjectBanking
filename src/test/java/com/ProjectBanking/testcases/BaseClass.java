package com.ProjectBanking.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ProjectBanking.utilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass{
	
	ReadConfig readConfig = new ReadConfig();
	public String baseURL=readConfig.getURL();
	public String username =readConfig.getUsername();
	public String password =readConfig.getPassword();
	public static WebDriver driver=null;
	public static Logger logger;
	
	/*
	 * public ExtentHtmlReporter htmlReporter; public ExtentReports extent; public
	 * ExtentTest test;
	 */
	public ITestResult result;
	 
	
	
	 //@BeforeMethod
		/*
		 * public void setExtent() { String str
		 * =System.getProperty("user.dir")+"\\ExtentReport\\myreport.html";
		 * System.out.println(str); htmlReporter=new
		 * ExtentHtmlReporter(System.getProperty("user.dir")+
		 * "\\ExtentReport\\myreport.html");
		 * htmlReporter.config().setDocumentTitle("Automation Report");
		 * htmlReporter.config().setReportName("Projectbanking Report");
		 * htmlReporter.config().setTheme(Theme.DARK);
		 * 
		 * extent=new ExtentReports(); extent.attachReporter(htmlReporter);
		 * extent.setSystemInfo("Hostname", "Localhost");
		 * extent.setSystemInfo("Test Name", "Login");
		 * extent.setSystemInfo("Browser","Chrome"); }
		 */

	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		logger = Logger.getLogger("ProjectBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equalsIgnoreCase("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver",readConfig.getchromeDriver());
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver",readConfig.getedgeDriver());
			driver = new EdgeDriver();
		}
		
		
		}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
			
	}
	
	
	 //@AfterMethod
	 /* public void flush(ITestResult result) {
	  if(result.getStatus() ==ITestResult.FAILURE)
	  test.log(Status.FAIL,"Test Case is failed"+result.getName()); else
	  if(result.getStatus() == ITestResult.SUCCESS)
	  test.log(Status.PASS,"Test Case is Passed"+result.getName()); else
	  if(result.getStatus() == ITestResult.SKIP)
	  test.log(Status.SKIP,"Test Case is skipped"+result.getName());
	  
	  extent.flush();
	  
	  }*/
	 
	
	

}
