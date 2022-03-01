package helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonFunctions {

	Logger logger = LoggerHelper.getLogger(CommonFunctions.class);
	
	private WebDriver driver;
	
	public CommonFunctions(WebDriver driver){
		this.driver = driver;
	}
	
	public void WaitForElement(WebElement element,long timeOutInSeconds){
		logger.info("waiting for element visibilityOf..");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		logger.info("element is visible..");
	}

	public void click(WebElement element){
		element.click();
	}

	//To find element
	public WebElement findElement(By locator)
	{
			return driver.findElement(locator);
	}
	
	//To check whether element is displayed in screen or not
	public boolean isElementDisplayed(WebElement element) {
		
		try {
			//System.out.println("Sidebar displayed "+getWebElement(sidebar).isDisplayed());
			return element.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	// Javascript executor to scroll to particular web element
	public void scrollToElement(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoViewIfNeeded()", element);  
		
	}
	
}
