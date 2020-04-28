//package com.org.implementation;
//
//import java.util.List;
//import java.util.Map;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import cucumber.api.DataTable;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class SignInStepdefinition{
//	ChromeDriver driver;
//
//	@Given("^Mercury registeration page is launched$")
//	public void mercury_registeration_page_is_launched() throws Throwable {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\manoj\\Downloads\\Documents\\tutorials\\Selenium\\setup\\chromedriver_80\\chromedriver.exe");
//		driver = new ChromeDriver();
//		 driver.get("http://newtours.demoaut.com/mercuryregister.php?osCsid=eb742473a826af6276b2ce47224b2c80");
//		
//	}
//
//	@When("^Username and Password is entered$")
//	public void username_and_Password_is_entered(DataTable arg1) throws Throwable {
//		for (Map<String, String> data : arg1.asMaps(String.class, String.class)) {
//			driver.findElement(By.name("userName")).sendKeys(data.get("username"));
//			driver.findElement(By.name("password")).sendKeys(data.get("password"));
//		}
//		// List<List<String>> data = arg1.raw();
//		// driver.findElement(By.name("userName")).sendKeys(data.get(0).get(0));
//		// driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
//	}
//
//	@When("^SignIn button is clicked$")
//	public void signin_button_is_clicked() throws Throwable {
//		driver.findElement(By.name("login")).click();
//	}
//
//	@Then("^User should be able to sign in$")
//	public void user_should_be_able_to_sign_in() throws Throwable {
//		System.out.println("__________");
//	}
//
//}
