package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class simpleForm {

	public WebDriver driver;
	WebDriverWait wait;

	public simpleForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 15);

	}

	@FindBy(css = "input#user-message")
	WebElement enterusermessage;

	public WebElement inputfield(String inputfield) {

		return driver.findElement(By.xpath("//div[text()='" + inputfield + "']"));

	}

	public WebElement button(String buttontext) {

		return driver.findElement(By.xpath("//button[text()='" + buttontext + "']"));

	}

	public WebElement enterusermessage() {

		return enterusermessage;

	}

	public WebElement successmessage(String messageselector) {
		return driver.findElement(By.cssSelector("span#" + messageselector + ""));
	}

	public WebElement values(String sum) {

		return driver.findElement(By.cssSelector("input#" + sum + ""));

	}

}
