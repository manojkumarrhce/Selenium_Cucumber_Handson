package com.org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.util.Testbase;



public class FlightConfirmationPage extends Testbase
{
	@FindBy(xpath="//table/tbody/tr[3]/td/p/font/b/font[2]")
	WebElement txtflightconfirmation;
	@FindBy(xpath="(//table/tbody/tr/td[1]/b/font/font/b/font[1])[1]")
	WebElement txtflightconfirmationnumber;
	@FindBy(xpath="//table/tbody/tr/td[3]/a/img")
	WebElement btnlogout;
	
	//initialization
	public FlightConfirmationPage() {
		super(prop.getProperty("Testdatapath"));
		PageFactory.initElements(driver, this);
	}
	//Action
	
	public String ValidateFlightConfirmationPageTitle() {
		return driver.getTitle();
	}
	
	public void verifyconfirmationpage()
	{
		if(txtflightconfirmation.getText().equals("Your itinerary has been booked!"))
			System.out.println("Confirmed");
		//---------get flight registration number-----
		Testbase.setCellData("Sheet1", "flightconfirmationnumber", 2, txtflightconfirmationnumber.getText());
		
		
	}
}
