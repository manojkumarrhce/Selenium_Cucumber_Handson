package com.org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codoid.products.exception.FilloException;
import com.org.util.Testbase;

public class FindAFlightPage extends Testbase {
	@FindBy(xpath = "//input[@name='tripType'][@value='oneway']")
	WebElement radiooneway;
	@FindBy(xpath = "//select[@name='passCount']")
	WebElement drppasscount;
	@FindBy(xpath="//select[@name='fromPort']")
	WebElement drpdepartfrom;
	@FindBy(xpath="//select[@name='fromMonth']")
	WebElement drpdepartonmonth;
	@FindBy(xpath="//select[@name='fromDay']")
	WebElement drpdepartonday;
	@FindBy(xpath="//select[@name='toPort']")
	WebElement drparrivingto;
	@FindBy(xpath="//select[@name='toMonth']")
	WebElement drparrivingmonth;
	@FindBy(xpath="//select[@name='toDay']")
	WebElement drparrivingonday;
	@FindBy(xpath="//input[@type='radio'][@value='Business']")
	WebElement radioBusinessclass;
	@FindBy(xpath="//select[@name='airline']")
	WebElement drpairline;
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement btncontinue;
	// initial
	
	public FindAFlightPage() {
		super(prop.getProperty("Testdatapath"));
		PageFactory.initElements(driver, this);
	}
	

	// actions
	public String ValidateFindAFlightPageTitle(){
		return driver.getTitle();
	}

	public void EnterFlightdetails() throws FilloException {
		radiooneway.click();
//		Testbase.drpselectbyindex(drppasscount, 1);
//		Testbase.drpselectbyindex(drpdepartfrom, 1);
//		Testbase.drpselectbyindex(drpdepartonmonth, 1);
		Testbase.drpselectbyvalue(drppasscount, Testbase.getCellData("Sheet1", "Passengers", 2));
		//Testbase.drpselectbyvalue(drppasscount, Testbase.datareader("Passengers"));
		Testbase.drpselectbyvalue(drpdepartfrom, Testbase.getCellData("Sheet1", "Departingfrom", 2));
		//Testbase.drpselectbyvisible(drpdepartfrom, Testbase.datareader("Departingfrom"));
		Testbase.drpselectbyvisible(drpdepartonmonth, Testbase.getCellData("Sheet1", "DepartingMonth", 2));
		Testbase.drpselectbyvalue(drpdepartonday, Testbase.getCellData("Sheet1", "DepartingDay", 2));
		
		
		Testbase.drpselectbyvalue(drparrivingto, Testbase.getCellData("Sheet1", "Arrivingfrom", 2));
		Testbase.drpselectbyvisible(drparrivingmonth, Testbase.getCellData("Sheet1", "ArrivingMonth", 2));
		Testbase.drpselectbyvalue(drparrivingonday, Testbase.getCellData("Sheet1", "ArrivingDay", 2));
		//Testbase.drpselectbyindex(drparrivingto, 1);
		//Testbase.drpselectbyindex(drparrivingmonth, 1);
		}
	public void EnterPreferences(){
		radioBusinessclass.click();
		Testbase.drpselectbyvisible(drpairline, Testbase.getCellData("Sheet1", "Airline", 2));
		//Testbase.drpselectbyindex(drpairline, 1);

	}
	public SelectFlightPage ClickSubmit()
	{
		btncontinue.click();
		return new SelectFlightPage();
	}
}
