package stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import enums.Browsers;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import testBase.BaseTest;


public class ApplicationHooks {

	BaseTest baseTest;
	
	//Puneetha added lines to add driver object
	private WebDriver driver;

	@Before
	public void initializeTest() {
		baseTest = new BaseTest();
		
		//Puneetha added lines to get driver object
		driver= baseTest.selectBrowser(Browsers.CHROME.name());
	}

	//Puneetha added lines to quit browser after executing all test cases
	@After(order=0)
	public void quitBrowser() throws IOException
	{
		driver.quit();
	}
	
	@After(order=1)
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {

			try {
				final byte[] screenshot = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png"); // ... and embed it in
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
//				scenario.embed(((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES), "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//		TestBase.driver.quit();
	}
}
