package com.ProjectBanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	
	WebDriver driver;
	
	public Loginpage(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(ldriver,this);
	}
	
	@FindBy(name="uid")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	public void setUsername(String username)
	{
		txtUsername.sendKeys(username);
		
		
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
		
		
	}
	
	public void clicklogin()
	{
		
		btnLogin.click();
	}
	
	
	
	
	

}
