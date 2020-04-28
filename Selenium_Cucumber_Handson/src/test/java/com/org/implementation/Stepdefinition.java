/*package com.org.implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefinition extends Reusablecomp{
	ChromeDriver driver;

	@Given("^Mercury registeration page is launched$")
	public void mercury_registeration_page_is_launched() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\manoj\\Downloads\\Documents\\tutorials\\Selenium\\setup\\chromedriver_80\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.get("http://newtours.demoaut.com/mercuryregister.php?osCsid=eb742473a826af6276b2ce47224b2c80");
		driver.get(Reusablecomp.readprop("URL"));

	}

	@When("^([^\"]*) and ([^\"]*) and ([^\"]*) is entered$")
	public void username_and_Password_and_ConfirmPassword_is_entered(String Username, String Password, String ConfirmPassword) throws Throwable {
		driver.findElement(By.name("email")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("confirmPassword")).sendKeys(ConfirmPassword);
	}

	@When("^Submit button is clicked$")
	public void submit_button_is_clicked() throws Throwable {
		//driver.findElement(By.name("register")).click();
	}

	@Then("^User should be registered$")
	public void user_should_be_registered() throws Throwable {
		if (driver.getPageSource().contains("Thank you for registering")) {
			System.out.println("Registered successfully");
		}
	}



}
*/