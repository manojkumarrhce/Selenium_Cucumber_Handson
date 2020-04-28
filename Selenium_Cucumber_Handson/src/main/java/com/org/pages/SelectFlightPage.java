package com.org.pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.util.Testbase;

public class SelectFlightPage extends Testbase {


	// @FindBy(xpath = "(//input[@type='radio'][@name='outFlight'])[2]")
	// WebElement radiodepartflight;
	// @FindBy(xpath = "(//input[@type='radio'][@name='inFlight'])[2]")
	// WebElement radioreturnflight;
	@FindBy(xpath = "//input[@name='reserveFlights']")
	WebElement btncontinue;

	// initialisation
	public SelectFlightPage() {
		super(prop.getProperty("Testdatapath"));
		PageFactory.initElements(driver, this);
	}

	// actions
	public String ValidateSelectFlightPageTitle() {
		return driver.getTitle();
	}

	public  void selectdepartflight() {
		// radiodepartflight.click();
		for (int i = 3; i <= 10; i+=2) {
			//table/tbody/tr[9]/td[2]/font/b
			String txt = driver.findElement(By.xpath("//table[1]/tbody/tr["+ i +"]/td[2]/font/b")).getText().trim();
			if (txt.contains(Testbase.getCellData("Sheet1", "Departflight", 2).trim())) 
			{
				driver.findElement(By.xpath("//table[1]/tbody/tr["+i+ "]/td[1]/input")).click();
				i++;
				String depprice = driver.findElement(By.xpath("//table[1]/tbody/tr["+ i +"]/td/font/font")).getText().trim(); 
				//Price: $271 (based on round trip)
				//System.out.println("deprice"+depprice);
				depprice=depprice.substring(8, 11);
				Testbase.setCellData("Sheet1", "Departflightprice", 2, depprice);
				break;		
			}
		}
	}
	
	public void selectreturnflight() {
		// radioreturnflight.click();
		for (int i = 3; i <= 10; i+=2) {
			String txt = driver.findElement(By.xpath("//table[2]/tbody/tr["+ i +"]/td[2]/font/b")).getText().trim();
			if (txt.contains(Testbase.getCellData("Sheet1", "Returnflight", 2).trim())) 
			{
				driver.findElement(By.xpath("//table[2]/tbody/tr["+i+ "]/td[1]/input")).click();
				i++;
				//table[1]/tbody/tr[6]/td/font/font
				String retprice = driver.findElement(By.xpath("//table[2]/tbody/tr["+ i +"]/td/font/font")).getText().trim(); 
				//Price: $271 (based on round trip)
				retprice=retprice.substring(8, 11);
				Testbase.setCellData("Sheet1", "Returnflightprice", 2, retprice);
				break;
			}
		}
		
	}
	

	public BookAFlightPage clickcontinue() {
		btncontinue.click();
		return new BookAFlightPage();
	}

}
