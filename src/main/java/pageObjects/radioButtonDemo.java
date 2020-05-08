package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class radioButtonDemo {

	public WebDriver driver;
	WebDriverWait wait;

	public radioButtonDemo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 15);

	}

	public String sex;
	public String Age;


	@FindBy(css = "button#buttoncheck")
	WebElement getcheckedvaluebutton;
	@FindBy(xpath = "//button[text()='Get values']")
	WebElement getvaluesbutton;
	public WebElement radiobuttondemo(String radiobuttondemoname) {
		
		return driver.findElement(By.xpath("//div[text()='"+radiobuttondemoname+"']"));

	}
	public WebElement agegrouprange(String agegrouprange) {
		
		return driver.findElement(By.cssSelector("input[value='"+agegrouprange+"']"));

	}
	
	public WebElement singleradio(String gendername)
	{
		return driver.findElement(By.cssSelector("input[value='"+gendername+"'][name='optradio']"));
	}


	public WebElement getcheckedvaluebutton() {
		return getcheckedvaluebutton;

	}
	public WebElement groupradioselection(String gender)
	{
		return driver.findElement(By.cssSelector("input[value='"+gender+"'][name='gender']"));
	}

	public WebElement multipleradiobuttonfields(String fieldvalue) {
		return driver.findElement(By.xpath("//h4[text()='"+fieldvalue+" : ']")) ;

	}
	public WebElement getvaluesbutton() {
		return getvaluesbutton;

	}

	public WebElement sucesssmessage(String gender) {
		
		return driver.findElement(By.xpath("//p[text()=\"Radio button '"+gender+"' is checked\"]"));

	}
	public WebElement groupsuccessmessage(String sex, String Age) {
		
		return driver.findElement(By.xpath("//p[text()='Sex : "+sex+"'][text()=' Age group: "+Age+"']"));

		

	}
}
