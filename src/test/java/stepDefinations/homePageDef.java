package stepDefinations;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;


import pageObjects.baseClass;
import pageObjects.homePage;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
public class homePageDef extends baseClass {

	public WebDriver driver;

	String title = "Selenium Easy - Best Demo website to practice Selenium Webdriver Online";

	@Given("^Firefox driver intialize$")
	public void firefox_driver_intialize() throws Throwable {

		driver = intializeDriver();

	}

	@When("^URL passed when browser get open$")
	public void url_passed_when_browser_get_open() throws Throwable {

		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();

	}

	@Then("^Print page title in console$")
	public void print_page_title_in_console() throws Throwable {
		homePage hp = new homePage(driver);
		if(homePage.alertstatus==false)
		{
			hp.alerthandle();
		}
		Assert.assertTrue(driver.getTitle().toString().contentEquals(title));

	}
}