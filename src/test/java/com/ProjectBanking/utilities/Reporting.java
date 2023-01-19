package com.ProjectBanking.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test; 
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest("Test "+result.getName());
		 if(result.getStatus() == ITestResult.SUCCESS)
			  test.log(Status.PASS,"Test Case is Passed "+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest("Test "+result.getName());
		 if(result.getStatus() ==ITestResult.FAILURE)
			  test.log(Status.FAIL,"Test Case is failed"+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest("Test "+result.getName());
		 if(result.getStatus() == ITestResult.SKIP)
			  test.log(Status.SKIP,"Test Case is skipped"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		  String str =System.getProperty("user.dir")+"\\ExtentReport\\myreport.html";
		  System.out.println(str); htmlReporter=new
		  ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReport\\myreport.html");
		  htmlReporter.config().setDocumentTitle("Automation Report");
		  htmlReporter.config().setReportName("Projectbanking Report");
		  htmlReporter.config().setTheme(Theme.DARK);
		  
		  extent=new ExtentReports(); extent.attachReporter(htmlReporter);
		  extent.setSystemInfo("Hostname", "Localhost");
		  extent.setSystemInfo("Test Name", "Login");
		  extent.setSystemInfo("Browser","Chrome");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		 extent.flush();
	}

	
	
}
