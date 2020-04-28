package com.org.implementation;

import org.junit.Assert;

import com.org.pages.FindAFlightPage;
import com.org.pages.LoginPage;
import com.org.util.Testbase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginPageSD extends Testbase{
	LoginPage LP;
	FindAFlightPage FP;
	
	public LoginPageSD() {
		super();
	}
	
	@Given("^Mercury registration page is launched$")
	public void mercury_registration_page_is_launched() throws Throwable {
		Testbase.initialization();
	}

	@When("^Username and Password are entered$")
	public void username_and_Password_are_entered() throws Throwable {
		LP = new LoginPage();
		String LPtitle = LP.ValidateLoginPageTitle();
		//System.out.println(LPtitle);
		Assert.assertEquals("Welcome: Mercury Tours", LPtitle);
		LP.login(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}


	@Then("^Find A Flight page is displayed$")
	public void find_A_Flight_page_is_displayed() throws Throwable {
		FP = new FindAFlightPage();
		String FPTitle = FP.ValidateFindAFlightPageTitle();
		Assert.assertEquals("Find a Flight: Mercury Tours:", FPTitle);
	}


}
