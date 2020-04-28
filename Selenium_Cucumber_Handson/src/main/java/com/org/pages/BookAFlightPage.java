package com.org.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codoid.products.exception.FilloException;
import com.org.util.Testbase;

import junit.framework.Assert;

public class BookAFlightPage extends Testbase {

	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/font")
	WebElement txtpasscount;
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/font")
	WebElement txttax;
	@FindBy(xpath = "//table/tbody/tr[9]/td[2]/font/b")
	WebElement txttotalprice;
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]/b/font")
	WebElement txtstartingdate;
	@FindBy(xpath = "//table/tbody/tr[4]/td[2]/b/font")
	WebElement txtdeparturedate;
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[1]/b/font")
	WebElement txtstartingcountry;
	@FindBy(xpath = "")
	WebElement txtdeparturecountry;
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/font/b")
	WebElement txtstartingflight;
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[1]/font/font/font[1]/b")
	WebElement txtdepartingflight;
	// @FindBy(xpath="")
	// WebElement ;

	@FindBy(name = "passFirst0")
	WebElement txtfirstnamep0;
	@FindBy(name = "passLast0")
	WebElement txtlastnamep0;
	@FindBy(name = "passFirst1")
	WebElement txtfirstnamep1;
	@FindBy(name = "passLast1")
	WebElement txtlastnamep1;
	@FindBy(name = "passFirst2")
	WebElement txtfirstnamep2;
	@FindBy(name = "passLast2")
	WebElement txtlastnamep2;
	@FindBy(name = "passFirst3")
	WebElement txtfirstnamep3;
	@FindBy(name = "passLast3")
	WebElement txtlastnamep3;
	@FindBy(xpath = "//select[@name='pass.0.meal']")
	WebElement drpmealp0;
	@FindBy(xpath = "//select[@name='pass.1.meal']")
	WebElement drpmealp1;
	@FindBy(xpath = "//select[@name='pass.2.meal']")
	WebElement drpmealp2;
	@FindBy(xpath = "//select[@name='pass.3.meal']")
	WebElement drpmealp3;
	@FindBy(xpath = "//select[@name='creditCard']")
	WebElement drpcreditcardtype;
	@FindBy(name = "creditnumber")
	WebElement txtcreditcardno;
	@FindBy(name = "cc_frst_name")
	WebElement txtcreditfname;
	@FindBy(name = "cc_last_name")
	WebElement txtcreditlname;
	@FindBy(xpath = "//input[@name='buyFlights']")
	WebElement btnsecurepurchase;

	// initial
	public BookAFlightPage() {
		super(prop.getProperty("Testdatapath"));
		PageFactory.initElements(driver, this);
	}

	// actions
	public String ValidateBookAFlightPageTitle() {
		return driver.getTitle();
	}

	public void ValidateSummaryPage() throws Exception {
		//-------------date check-------------
		String startdate= Testbase.getCellData("Sheet1", "DepartingDay", 2).trim();
		int intstartdate = Integer.parseInt(startdate);// string to int
		String stringstartmonth= Testbase.getCellData("Sheet1", "DepartingMonth", 2).trim();
		int intstartmonth = Testbase.monthnametonumber(stringstartmonth);
		 String startingdate = intstartmonth + "/" +intstartdate + "/2020";
		 Assert.assertEquals(txtstartingdate.getText(), startingdate);
		 
			String enddate= Testbase.getCellData("Sheet1", "ArrivingDay", 2).trim();
			int intenddate = Integer.parseInt(enddate);// string to int
			String stringendmonth= Testbase.getCellData("Sheet1", "ArrivingMonth", 2).trim();
			int intendmonth = Testbase.monthnametonumber(stringendmonth);
			 String endingdate = intstartmonth + "/" +intstartdate + "/2020";
			 Assert.assertEquals(txtdeparturedate.getText(), endingdate);
			
		// ------------passenger check----------
		String exppcount = Testbase.getCellData("Sheet1", "Passengers", 2).trim();
		String actualpcount = txtpasscount.getText().trim();
		Assert.assertEquals(exppcount, actualpcount);
		// ---------tax calc-------------------
		int actualintpcount = Integer.parseInt(exppcount);// string to int
		double tax = actualintpcount * 44.4;
		int tax1 = (int) Math.round(tax);
		String calctax = "$" + String.valueOf(tax1); // Converting int to String
		Assert.assertEquals(calctax, txttax.getText().trim());

		// -------------total price---------
		String Departflightprice = Testbase.getCellData("Sheet1", "Departflightprice", 2).trim();
		int Departflightpriceint = Integer.parseInt(Departflightprice);
		String Returnflightprice = Testbase.getCellData("Sheet1", "Returnflightprice", 2).trim();
		int Returnflightpriceint = Integer.parseInt(Returnflightprice);
		int totalprice = tax1 + (Departflightpriceint + Returnflightpriceint) * actualintpcount;
		String stotalprice = "$" + String.valueOf(totalprice);
		Assert.assertEquals(stotalprice, txttotalprice.getText().trim());
	}

	public void EnterPassengerDetails() throws FilloException {
		String pcount = Testbase.getCellData("Sheet1", "Passengers", 2);
		// String s3 = new String(Testbase.getCellData("Sheet1", "Passengers",
		// 2));
		int pintcount = Integer.parseInt(pcount);
		if (pintcount == 1) {
			txtfirstnamep0.sendKeys(Testbase.getCellData("Sheet1", "FirstName_0", 2));
			txtlastnamep0.sendKeys(Testbase.getCellData("Sheet1", "LastName_0", 2));
			Testbase.drpselectbyvisible(drpmealp0, Testbase.getCellData("Sheet1", "Meal_0", 2));
		} else if (pintcount == 2) {
			txtfirstnamep0.sendKeys(Testbase.getCellData("Sheet1", "FirstName_0", 2));
			txtlastnamep0.sendKeys(Testbase.getCellData("Sheet1", "LastName_0", 2));
			txtfirstnamep1.sendKeys(Testbase.getCellData("Sheet1", "FirstName_1", 2));
			txtlastnamep1.sendKeys(Testbase.getCellData("Sheet1", "LastName_1", 2));
			Testbase.drpselectbyvisible(drpmealp0, Testbase.getCellData("Sheet1", "Meal_0", 2));
			Testbase.drpselectbyvisible(drpmealp1, Testbase.getCellData("Sheet1", "Meal_1", 2));
		} else if (pintcount == 3) {
			txtfirstnamep0.sendKeys(Testbase.getCellData("Sheet1", "FirstName_0", 2));
			txtlastnamep0.sendKeys(Testbase.getCellData("Sheet1", "LastName_0", 2));
			txtfirstnamep1.sendKeys(Testbase.getCellData("Sheet1", "FirstName_1", 2));
			txtlastnamep1.sendKeys(Testbase.getCellData("Sheet1", "LastName_1", 2));
			txtfirstnamep2.sendKeys(Testbase.getCellData("Sheet1", "FirstName_2", 2));
			txtlastnamep2.sendKeys(Testbase.getCellData("Sheet1", "LastName_2", 2));
			Testbase.drpselectbyvisible(drpmealp0, Testbase.getCellData("Sheet1", "Meal_0", 2));
			Testbase.drpselectbyvisible(drpmealp1, Testbase.getCellData("Sheet1", "Meal_1", 2));
			Testbase.drpselectbyvisible(drpmealp2, Testbase.getCellData("Sheet1", "Meal_2", 2));
		} else if (pintcount == 4) {
			txtfirstnamep0.sendKeys(Testbase.getCellData("Sheet1", "FirstName_0", 2));
			txtlastnamep0.sendKeys(Testbase.getCellData("Sheet1", "LastName_0", 2));
			txtfirstnamep1.sendKeys(Testbase.getCellData("Sheet1", "FirstName_1", 2));
			txtlastnamep1.sendKeys(Testbase.getCellData("Sheet1", "LastName_1", 2));
			txtfirstnamep2.sendKeys(Testbase.getCellData("Sheet1", "FirstName_2", 2));
			txtlastnamep2.sendKeys(Testbase.getCellData("Sheet1", "LastName_2", 2));
			txtfirstnamep3.sendKeys(Testbase.getCellData("Sheet1", "FirstName_3", 2));
			txtlastnamep3.sendKeys(Testbase.getCellData("Sheet1", "LastName_3", 2));
			Testbase.drpselectbyvisible(drpmealp0, Testbase.getCellData("Sheet1", "Meal_0", 2));
			Testbase.drpselectbyvisible(drpmealp1, Testbase.getCellData("Sheet1", "Meal_1", 2));
			Testbase.drpselectbyvisible(drpmealp2, Testbase.getCellData("Sheet1", "Meal_2", 2));
			Testbase.drpselectbyvisible(drpmealp3, Testbase.getCellData("Sheet1", "Meal_3", 2));
		}
	}

	public void EnterCardDetails() {
		Testbase.drpselectbyvisible(drpcreditcardtype, Testbase.getCellData("Sheet1", "CreditCardType", 2));
		txtcreditcardno.sendKeys(Testbase.getCellData("Sheet1", "CreditNumber", 2));
		txtcreditfname.sendKeys(Testbase.getCellData("Sheet1", "FirstName_0", 2));
		txtcreditlname.sendKeys(Testbase.getCellData("Sheet1", "LastName_0", 2));
	}

	public FlightConfirmationPage ClickSecurePurchase() {
		btnsecurepurchase.click();
		return new FlightConfirmationPage();
	}
}
