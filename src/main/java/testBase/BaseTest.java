package testBase;

import enums.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {

    public static WebDriver driver;


    public WebDriver selectBrowser(String browser) {
        if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
        }
        
        //Puneetha to delete cookies and maximize browser
        getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
