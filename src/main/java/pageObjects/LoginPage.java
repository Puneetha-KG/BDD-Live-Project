package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void enterUserName(String username) {
        driver.findElement(By.xpath("//*[@ name =\"username\"]")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.xpath("//*[@ name =\"password\"]")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
    }
}
