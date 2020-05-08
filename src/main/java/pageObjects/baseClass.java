package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class baseClass {

	public static WebDriver driver;
	public Properties prop;
	public String allexamples="All Examples";
	public String inputforms="Input Forms";
	public String simpleformdemo="Simple Form Demo";
	public String checkboxdemo="Checkbox Demo";
	public String radiobuttondemo="Radio Buttons Demo";
	public String selectdropdownlist="Select Dropdown List";
	public String inputformsubmit="Input Form Submit";
	public String ajaxformsubmit="Ajax Form Submit";
	public String jqueryselectdropdown="JQuery Select dropdown";
	

	public WebDriver intializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\SeleniumEasy\\resources\\Data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver_win321\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\geckodriver-v0.26.0\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "E:\\Selenium\\IEDriverServer_x64_2.39.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else {
			System.out.println("Please provide valid browser from chrome,firefox,IE,");

		}
		return driver;

	}

	public void getScreenShot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("E://scr//" + result + "screenshot.png"));

	}
	
	public static WebDriver getdriver()
	{
		return driver;
		
	}
	
	

}
