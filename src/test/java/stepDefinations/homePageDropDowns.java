package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;

import pageObjects.baseClass;
import pageObjects.homePage;

import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)

public class homePageDropDowns extends baseClass {

	public WebDriver driver = getdriver();

	homePage hp = new homePage(driver);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	
	@Given("^All examples dropdown appears on page$")
	public void all_examples_dropdown_appears_on_page() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(hp.mainnavigation(allexamples)));
		Assert.assertTrue(hp.mainnavigation(allexamples).isDisplayed());

	}

	@When("^click on input forms$")
	public void click_on_input_forms() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(hp.mainnavigation(inputforms)));
		hp.mainnavigation(inputforms).click();

	}

	@Then("^click on Simple Form demo$")
	public void click_on_simple_form_demo() throws Throwable {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("scroll(0,350)");
		wait.until(ExpectedConditions.visibilityOf(hp.subnavigation(simpleformdemo)));
		hp.subnavigation(simpleformdemo).click();

	}

}