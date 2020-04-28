package com.org.implementation;

import com.org.pages.BookAFlightPage;
import com.org.util.Testbase;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookAFlightSD extends Testbase{
	public BookAFlightSD() 
	{
	super();
	}
	
	BookAFlightPage BAF;
	@Given("^Book a Flight page is displayed$")
	public void book_a_Flight_page_is_displayed() throws Throwable {
		BAF = new BookAFlightPage();
		BAF.ValidateBookAFlightPageTitle();
}

	@When("^Summary section is verified$")
	public void summary_section_is_verified() throws Throwable {
		BAF.ValidateSummaryPage();
}

	@When("^Enter the passenger details$")
	public void enter_the_passenger_details() throws Throwable {
		BAF.EnterPassengerDetails();
}

	@When("^Enter the billing address$")
	public void enter_the_billing_address() throws Throwable {
		BAF.EnterCardDetails();
}

	@Then("^click on secure purchase button and verify Flight confirmation page should be displayed$")
	public void click_on_secure_purchase_button_and_verify_Flight_confirmation_page_should_be_displayed() throws Throwable {
		BAF.ClickSecurePurchase();
}



}
