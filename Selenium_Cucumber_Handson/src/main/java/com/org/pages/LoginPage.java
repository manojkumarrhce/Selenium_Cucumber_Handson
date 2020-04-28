package com.org.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.util.Testbase;
import com.org.util.Testutil;

public class LoginPage extends Testbase {
	@FindBy(name = "userName")
	WebElement txtusername;
	@FindBy(name = "password")
	WebElement txtpassword;
	@FindBy(name = "login")
	WebElement btnsignin;

	// initialization
	public LoginPage() {
		super(prop.getProperty("Testdatapath"));
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}

	public FindAFlightPage login(String un, String pwd) {
		txtusername.sendKeys(prop.getProperty("Username"));
		txtpassword.sendKeys(prop.getProperty("Password"));
		btnsignin.click();
		
		return new FindAFlightPage();
	}
}
