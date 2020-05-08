package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.baseClass;
import pageObjects.checkBoxDemo;
import pageObjects.homePage;
import org.junit.Assert;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
public class checkBoxDemoDef extends baseClass {
	
	public WebDriver driver=getdriver();

	homePage hp = new homePage(driver);
	checkBoxDemo cb = new checkBoxDemo(driver);
	WebDriverWait wait = new WebDriverWait(driver, 15);

	@Given("^Input forms dropdown is shown on Simple Form demo page$")
	public void input_forms_dropdown_is_shown_on_simple_form_demo_page() throws Throwable {

		Assert.assertTrue(hp.mainnavigation(inputforms).isDisplayed());
		hp.mainnavigation(inputforms).click();
	}

	@Given("^Single Checkbox Demo option should shown on page$")
	public void single_checkbox_demo_option_should_shown_on_page() throws Throwable {
		if(homePage.alertstatus==false)
		{
			hp.alerthandle();
		}
		Assert.assertTrue(cb.checkbox("Single Checkbox Demo").isDisplayed());
	}

	@Given("^Multiple Checkbox Demo option should shown on page$")
	public void multiple_checkbox_demo_option_should_shown_on_page() throws Throwable {

		Assert.assertTrue(cb.checkbox("Multiple Checkbox Demo").isDisplayed());
	}

	@When("^Click on Check box Demo option after expanding Input forms dropdown$")
	public void click_on_check_box_demo_option_after_expanding_input_forms_dropdown() throws Throwable {

		hp.subnavigation(checkboxdemo).click();

	}

	@When("^Check box is shown and click on check box option$")
	public void check_box_is_shown_and_click_on_check_box_option() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(cb.clickoncheckbox()));
		cb.clickoncheckbox().click();
	}

	@When("^Check All option shown on page then click on it$")
	public void check_all_option_shown_on_page_then_click_on_it() throws Throwable {
		
		wait.until(ExpectedConditions.visibilityOf(cb.checkboxselection("Check All")));

		if (cb.checkboxselection("Check All").isDisplayed()) {
			cb.checkboxselection("Check All").click();
		} else {
			System.out.println("Check All button is not shown on page");
		}

	}

	@Then("^Check box Demo page should load properly$")
	public void check_box_demo_page_should_load_properly() throws Throwable {
		Thread.sleep(1000);



	}

	@Then("^Check box should shown ticked$")
	public void check_box_should_shown_ticked() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(cb.singlecheckboxsuccess()));

		Assert.assertTrue(cb.singlecheckboxsuccess().isDisplayed());

	}

	@Then("^It should turn to Uncheck All$")
	public void it_should_turn_to_uncheck_all() throws Throwable {
		
		wait.until(ExpectedConditions.visibilityOf(cb.checkboxselection("Uncheck All")));
		Assert.assertTrue(cb.checkboxselection("Uncheck All").isDisplayed());

	}

	@Then("^Check if all button checked$")
	public void check_if_all_button_checked() throws Throwable {
		if (cb.checkboxselection("Uncheck All").isDisplayed()) {
			System.out.println("All button checked");
		} else {
			System.out.println("Some error occured");
		}

	}

	@Then("^Untick two check box options$")
	public void untick_two_check_box_options() throws Throwable {

		cb.checkboxoption("1").click();
		cb.checkboxoption("2").click();

	}

	@And("^Sucess message should shown underneath check box$")
	public void sucess_message_should_shown_underneath_check_box() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(cb.singlecheckboxsuccess()));
		Assert.assertTrue(cb.singlecheckboxsuccess().isDisplayed());

	}

	@And("^Check if button turned to Check All from Uncheck All button$")
	public void check_if_button_turned_to_check_all_from_uncheck_all_button() throws Throwable {

		if (cb.checkboxselection("Check All").isDisplayed()) {
			System.out.println("button turned to Check all from Uncheck all");
		} else {
			System.out.println("Some problem occured while unchecking checkbox");
		}

	}

}