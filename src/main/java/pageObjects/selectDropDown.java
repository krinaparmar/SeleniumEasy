package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class selectDropDown {
	
	public WebDriver driver;
	

	public selectDropDown(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//div[text()='Select List Demo']")
	WebElement selectlistdemo;
	@FindBy(css="select#select-demo")
	WebElement selectdaydropdown;
	@FindBy(xpath="//div[text()='Multi Select List Demo']")
	WebElement multiselectlistdemo;
	@FindBy(css="select#multi-select")
	WebElement multiselectdropdown;
	
	public WebElement selectlistdemo()
	{
		return selectlistdemo;
	}
	public WebElement selectdaydropdown()
	{
		return selectdaydropdown;
	}
	public WebElement dayvaluedropdown(String dayvalue) {
		
		return driver.findElement(By.xpath("//option[@value='"+dayvalue+"']"));
	}
	public WebElement dayvaluesuccesss(String dayvalue)
	{
		return driver.findElement(By.xpath("//p[text()='Day selected :- "+dayvalue+"']"));
	}
	public WebElement multiselectlistdemo()
	{
		return multiselectlistdemo;
	}
	public WebElement button(String buttonname)
	{
		return driver.findElement(By.xpath("//button[text()='"+buttonname+"']"));
	}
	
	public WebElement multiselectdemoselect(String cityvalue)
	{
		return driver.findElement(By.xpath("//option[text()='"+cityvalue+"']"));
	}
	public WebElement firstselectedsuccess(String first)
	{
		return driver.findElement(By.xpath("//p[text()='First selected option is : "+first+"']"));
	}
	public WebElement getallselectedsuccess(String first,String second,String third)
	{
		return driver.findElement(By.xpath("//p[text()='Options selected are : "+first+","+second+","+third+"']"));
	}
	public WebElement multiselectdropdown()
	{
		return multiselectdropdown;
	}
	
	
	
	


}
