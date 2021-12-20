package com.parabank.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parabank.TestBase.TestBase;

public class LoginPage extends TestBase {
	
	
	public LoginPage()
	{
		PageFactory.initElements(wd, this);
	}	
	
	@FindBy(css ="input[name='username']" )
	WebElement inputUserName;
	@FindBy(css = "input[name='password']")
	WebElement inputPasscode;
	@FindBy(css = "input[value='Log In']")
	WebElement loginButton;
	 
	public void login(String email,String pascode	) {
		
		inputUserName.sendKeys(email);
		inputPasscode.sendKeys(pascode);
		loginButton.submit();
		
	}
		
	
	public void login() {
		
	}
		

	
	
	
	
	
	

}
