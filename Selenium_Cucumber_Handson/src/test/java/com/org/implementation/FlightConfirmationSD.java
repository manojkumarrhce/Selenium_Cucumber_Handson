package com.org.implementation;
import org.junit.Assert;

import com.org.pages.FlightConfirmationPage;
import com.org.util.Testbase;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class FlightConfirmationSD extends Testbase {
	FlightConfirmationPage FCP = new FlightConfirmationPage();
	public FlightConfirmationSD() {
		super();
	}
	@Given("^Flight confirmation page is displayed$")
	public void flight_confirmation_page_is_displayed() throws Throwable {
		Assert.assertEquals("Flight Confirmation: Mercury Tours", FCP.ValidateFlightConfirmationPageTitle());
	}

	@When("^Booking confirmation text is verified$")
	public void booking_confirmation_text_is_verified() throws Throwable {
		FCP.verifyconfirmationpage();
		
	}

}
