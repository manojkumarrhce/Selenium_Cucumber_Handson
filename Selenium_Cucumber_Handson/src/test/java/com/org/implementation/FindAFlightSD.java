package com.org.implementation;

import org.junit.Assert;

import com.org.pages.FindAFlightPage;
import com.org.util.Testbase;
import com.org.util.Xls_Reader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FindAFlightSD extends Testbase
{
	FindAFlightPage FP;
	public FindAFlightSD() {
	super();
	}
	
	
	@Given("^Flight finder page is displayed$")
	public void flight_finder_page_is_displayed() throws Throwable {
		FP = new FindAFlightPage();
		String FPTitle = FP.ValidateFindAFlightPageTitle();
		Assert.assertEquals("Find a Flight: Mercury Tours:", FPTitle);
	}

	@When("^All flight details are entered$")
	public void all_flight_details_are_entered() throws Throwable {
		FP.EnterFlightdetails();
	}

	@When("^All preferences are entered and click on continue$")
	public void all_preferences_are_entered_and_click_on_continue() throws Throwable {
		FP.EnterPreferences();
	}

	@Then("^select flight page should be displayed$")
	public void select_flight_page_should_be_displayed() throws Throwable {
		FP.ClickSubmit();
	}

}
