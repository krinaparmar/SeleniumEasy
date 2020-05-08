package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.baseClass;
import pageObjects.homePage;
import pageObjects.selectDropDown;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
public class selectDropDownListDef extends baseClass {

	public WebDriver driver = getdriver();
	homePage hp = new homePage(driver);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	selectDropDown sdd = new selectDropDown(driver);
	public String firstvalue;
	public String secondvalue;
	public String thirdvalue;

	@Given("^Input forms dropdown is shown on Select Dropdown List page$")
	public void input_forms_dropdown_is_shown_on_select_dropdown_list_page() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(hp.mainnavigation(inputforms)));
		hp.mainnavigation(inputforms).click();

	}

	@Given("^Select List Demo option should shown on page$")
	public void select_list_demo_option_should_shown_on_page() throws Throwable {
		
		if(homePage.alertstatus==false)
		{
			hp.alerthandle();
		}
		Assert.assertTrue(sdd.selectlistdemo().isDisplayed());

	}

	@Given("^Multi Select List Demo option should shown on page$")
	public void multi_select_list_demo_option_should_shown_on_page() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(sdd.multiselectlistdemo()));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("scroll(0,350)");
		Assert.assertTrue(sdd.multiselectlistdemo().isDisplayed());

	}

	@When("^Click on Select Dropdown List option after expanding Input forms dropdown$")
	public void click_on_select_dropdown_list_option_after_expanding_input_forms_dropdown() throws Throwable {
		hp.subnavigation(selectdropdownlist).click();

	}

	@When("^Select a day dropdown appears then check for (.+) option$")
	public void select_a_day_dropdown_appears_then_check_for_option(String dayvalue) throws Throwable {
		Assert.assertTrue(sdd.selectdaydropdown().isDisplayed());
		sdd.selectdaydropdown().click();
		sdd.dayvaluedropdown(dayvalue).click();

	}

	@When("^Multiselect list shown on page$")
	public void multiselect_list_shown_on_page() throws Throwable {
		

	}

	@Then("^Select Dropdown List page should load properly$")
	public void select_dropdown_list_page_should_load_properly() throws Throwable {

	}

	@Then("^Select Tuesday option$")
	public void select_tuesday_option() throws Throwable {

	}

	@Then("^Click on (.+),(.+),(.+)$")
	public void click_on_(String first, String second, String third) throws Throwable {
		firstvalue = first;
		secondvalue = second;
		thirdvalue = third;
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.LEFT_CONTROL)
	    .click(sdd.multiselectdemoselect(firstvalue))
	    .click(sdd.multiselectdemoselect(secondvalue))
	    .click(sdd.multiselectdemoselect(thirdvalue))
	    .keyUp(Keys.LEFT_CONTROL)
	    .build()
	    .perform();
	}

	@Then("^Click on First Selected Button$")
	public void click_on_first_selected_button() throws Throwable {
		sdd.button("First Selected").click();

	}

	@Then("^Click on Get All Selected Buttton$")
	public void click_on_get_all_selected_buttton() throws Throwable {
		Thread.sleep(1000);
		sdd.button("Get All Selected").click();

	}

	@And("^Sucess message for Day selected (.+) should shown$")
	public void sucess_message_for_day_selected_should_shown(String dayvalue) throws Throwable {
		Assert.assertTrue(sdd.dayvaluesuccesss(dayvalue).isDisplayed());

	}

	@And("^Verify First Selected option (.+)$")
	public void verify_first_selected_option(String first) throws Throwable {
		Assert.assertTrue(sdd.firstselectedsuccess(first).isDisplayed());

	}

	@And("^Verify Get ALL selected option (.+),(.+),(.+)$")
	public void verify_get_all_selected_option_(String first, String second, String third) throws Throwable {
		Assert.assertTrue(sdd.getallselectedsuccess(first, second, third).isDisplayed());

	}

}