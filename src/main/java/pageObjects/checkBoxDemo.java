package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkBoxDemo {
	
	public WebDriver driver;
	WebDriverWait wait;

	public checkBoxDemo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 15);

	}
	
	@FindBy(css = "input#isAgeSelected")
	WebElement clickoncheckbox;
	@FindBy(xpath = "//div[text()='Success - Check box is checked']")
	WebElement singlecheckboxsuccess;
	@FindBy(xpath = "input[id='isChkd'][value='true']")
	WebElement multiplecheckboxsuccess;
	
	
	
	public WebElement checkbox(String checkbox)
	{
		return driver.findElement(By.xpath("//div[text()='"+checkbox+"']"));
	}
	public WebElement checkboxselection(String selection)
	{
		return driver.findElement(By.cssSelector("input[value='"+selection+"']"));
	}
	public WebElement checkboxoption(String optionno)
	{
		return driver.findElement(By.xpath("(//input[@class='cb1-element'])["+optionno+"]"));
	}
	public WebElement clickoncheckbox() {
		return clickoncheckbox;

	}
	public WebElement singlecheckboxsuccess() {
		return singlecheckboxsuccess;

	}
	public WebElement multiplecheckboxsuccess() {
		return multiplecheckboxsuccess;

	}
	
	
	
	

}
