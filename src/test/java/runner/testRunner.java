package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import pageObjects.baseClass;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = { "stepDefinations" })

public class testRunner{
	
	
	 @AfterClass
	    public static void teardown() {
		 baseClass.getdriver().quit();
		 baseClass.driver=null;
		
		 
				 
	       
	    }

}