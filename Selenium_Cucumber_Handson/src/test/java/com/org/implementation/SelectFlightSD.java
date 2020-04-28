package com.org.implementation;

import org.junit.Assert;

import com.org.pages.SelectFlightPage;
import com.org.util.Testbase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SelectFlightSD extends Testbase{
	public SelectFlightSD() {
	super();
	}
	SelectFlightPage SF;

	@Given("^SelectFlight page is displayed$")
	public void selectflight_page_is_displayed() throws Throwable {
		SF = new SelectFlightPage();
		String s=SF.ValidateSelectFlightPageTitle();
		Assert.assertEquals("Select a Flight: Mercury Tours", s);
	}

	@When("^Depart flight is selected$")
	public void depart_flight_is_selected() throws Throwable {
		SF.selectdepartflight();
	}

	@When("^Return flight is selected$")
	public void return_flight_is_selected_and_click_on_continue() throws Throwable {
		SF.selectreturnflight();
	}

	@Then("^click on continue and Book A Flight page should be displayed$")
	public void book_A_Flight_page_should_be_displayed() throws Throwable {
		SF.clickcontinue();
	}

}
