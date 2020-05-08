package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {

	public WebDriver driver;
	WebDriverWait wait;
	public static boolean alertstatus=false;

	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 15);

	}

	@FindBy(css = "#at-cv-lightbox-win")
	WebElement popup;
	@FindBy(xpath = "//a[text()='No, thanks!']")
	WebElement popupclose;

	public WebElement popup() {
		return popup;

	}

	public WebElement popupclose() {
		return popupclose;

	}

	public WebElement mainnavigation(String mainnavigationelement) {
		return driver.findElement(By.xpath("//a[text()='" + mainnavigationelement + "']"));
	}

	public WebElement subnavigation(String subnavigationelement) {
		return driver.findElement(By.xpath("(//a[text()='" + subnavigationelement + "'])[2]"));
	}

	public void alerthandle() throws NoSuchElementException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOf(popup()));
			if(popup().isDisplayed())
			{
				popupclose().click();
				System.out.println("Popup closed");
				alertstatus=true;
			}
			
		} catch (TimeoutException e) {
	
			
		}
		

	}

}
