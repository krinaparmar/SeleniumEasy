package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;
import pageObjects.baseClass;
import pageObjects.homePage;
import pageObjects.simpleForm;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
public class simpleFormDef extends baseClass {

	WebDriver driver = getdriver();

	simpleForm sf = new simpleForm(driver);
	homePage hp = new homePage(driver);
	WebDriverWait wait = new WebDriverWait(driver, 15);

	public String usermessage;
	public int c;
	public String field1 = "sum1";
	public String field2 = "sum2";

	@Given("^Single input field page is shown on page$")
	public void single_input_field_page_is_shown_on_page() throws Throwable {
		if(homePage.alertstatus==false)
		{
			hp.alerthandle();
		}
		wait.until(ExpectedConditions.visibilityOf(sf.inputfield("Single Input Field")));
		Assert.assertTrue(sf.inputfield("Single Input Field").isDisplayed());

	}

	@Given("^two input field page is shown on page$")
	public void two_input_field_page_is_shown_on_page() throws Throwable {
		Assert.assertTrue(sf.inputfield("Two Input Fields").isDisplayed());

	}

	@When("^(.+) is passes in text field and click on show button$")
	public void is_passes_in_text_field_and_click_on_show_button(String message) throws Throwable {
		sf.enterusermessage().sendKeys(message);
		usermessage = message;
		sf.button("Show Message").click();
	}

	@When("^Value for (\\d+) field and value for (\\d+) field passed then click on get total$")
	public void value_for_something_field_and_value_for_something_field_passed_then_click_on_get_total(int i, int j)
			throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(sf.values(field1)));
		sf.values(field1).sendKeys(String.valueOf(i));
		sf.values(field2).sendKeys(String.valueOf(j));
		c = i + j;
		sf.button("Get Total").click();
	}

	@Then("^Message should appear in your message area$")
	public void message_should_appear_in_your_message_area() throws Throwable {

		Assert.assertTrue(sf.successmessage("display").isDisplayed());
	}

	@Then("^Total should appear$")
	public void total_should_appear() throws Throwable {

		Assert.assertTrue(sf.successmessage("displayvalue").isDisplayed());

	}

	@And("^Validate both message$")
	public void validate_both_message() throws Throwable {

		Assert.assertTrue(sf.successmessage("display").getText().contentEquals(usermessage));

	}

	@And("^Validate total value$")
	public void validate_total_value() throws Throwable {

		Assert.assertTrue(sf.successmessage("displayvalue").getText().toString().contentEquals(String.valueOf(c)));
	}

}