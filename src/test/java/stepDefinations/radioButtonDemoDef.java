package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;
import pageObjects.baseClass;
import pageObjects.homePage;
import pageObjects.radioButtonDemo;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
public class radioButtonDemoDef extends baseClass {

	public WebDriver driver = getdriver();

	homePage hp = new homePage(driver);
	radioButtonDemo rbd = new radioButtonDemo(driver);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	public String groupsex;
	public String agegroup;

	@Given("^Input forms dropdown is shown on Check Box demo page$")
	public void input_forms_dropdown_is_shown_on_check_box_demo_page() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(hp.mainnavigation(inputforms)));
		hp.mainnavigation(inputforms).click();

	}

	@Given("^Radio Button Demo option should shown on page$")
	public void radio_button_demo_option_should_shown_on_page() throws Throwable {
		if(homePage.alertstatus==false)
		{
			hp.alerthandle();
		}
		wait.until(ExpectedConditions.visibilityOf(rbd.radiobuttondemo("Radio Button Demo")));
		Assert.assertTrue(rbd.radiobuttondemo("Radio Button Demo").isDisplayed());

	}

	@Given("^Group Radio Buttons Demo option should shown on page$")
	public void group_radio_buttons_demo_option_should_shown_on_page() throws Throwable {
		Assert.assertTrue(rbd.radiobuttondemo("Group Radio Buttons Demo").isDisplayed());

	}

	@When("^Click on Radio button demo option after expanding Input forms dropdown$")
	public void click_on_radio_button_demo_option_after_expanding_input_forms_dropdown() throws Throwable {

		hp.subnavigation(radiobuttondemo).click();

	}

	@When("^Radio option appears then click on \"([^\"]*)\" Radio button option$")
	public void radio_option_appears_then_click_on_something_radio_button_option(String strArg1) throws Throwable {
		if (strArg1.matches("Male")) {
			rbd.singleradio("Male").click();
		} else {
			rbd.singleradio("Female").click();
		}

	}

	@When("^Sex and Age group options shows on page$")
	public void sex_and_age_group_options_shows_on_page() throws Throwable {
		Assert.assertTrue(rbd.multipleradiobuttonfields("Sex").isDisplayed());
		Assert.assertTrue(rbd.multipleradiobuttonfields("Age Group").isDisplayed());

	}

	@Then("^Radio Button Demo page should load properly$")
	public void radio_button_demo_page_should_load_properly() throws Throwable {

	}

	@Then("^Click on Get Checked Value button$")
	public void click_on_get_checked_value_button() throws Throwable {
		rbd.getcheckedvaluebutton().click();

	}

	@Then("^Click on \"([^\"]*)\" radio button$")
	public void click_on_something_radio_button(String strArg1) throws Throwable {

		if (strArg1.matches("Male")) {
			rbd.groupradioselection("Male").click();
		} else {
			rbd.groupradioselection("Female").click();
		}

	}

	@Then("^Click on \"([^\"]*)\" Age group$")
	public void click_on_something_age_group(String strArg1) throws Throwable {

		if (strArg1.matches("5 to 15")) {
			rbd.agegrouprange("5 - 15").click();
		} else if (strArg1.matches("0 to 5")) {
			rbd.agegrouprange("0 - 5").click();
		} else {
			rbd.agegrouprange("15 - 50").click();
		}

	}

	@Then("^Click on Get Values options$")
	public void click_on_get_values_options() throws Throwable {
		rbd.getvaluesbutton().click();

	}

	@And("^Sucess message for \"([^\"]*)\" radio button should show underneath check box$")
	public void sucess_message_for_something_radio_button_should_show_underneath_check_box(String strArg1)
			throws Throwable {
		if (strArg1.matches("Male")) {
			Assert.assertTrue(rbd.sucesssmessage("Male").isDisplayed());

		} else {
			Assert.assertTrue(rbd.sucesssmessage("Female").isDisplayed());
		}

	}

	@And("^Verify Sex \"([^\"]*)\" and \"([^\"]*)\" values$")
	public void verify_sex_something_and_something_values(String strArg1, String strArg2) throws Throwable {
		groupsex = strArg1;
		agegroup = strArg2;

		Thread.sleep(1000);
		Assert.assertTrue(rbd.groupsuccessmessage(groupsex, agegroup).isDisplayed());

	}

}