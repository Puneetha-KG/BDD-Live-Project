package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import testBase.BaseTest;

public class Login extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);

    @Given("^I am on the Login page URL \"([^\"]*)\"$")
    public void i_am_on_the_Login_page_URL(String URL) throws Throwable {
        driver.get(URL);
    }

    @When("^Enter userName \"([^\"]*)\"$")
    public void enter_userName(String username) throws Throwable {
        loginPage.enterUserName(username);
    }

    @When("^Enter Password  \"([^\"]*)\"$")
    public void enter_password(String password) throws Throwable {
        loginPage.enterPassword(password);
    }

    @Then("Click on Submit Button")
    public void click_Submit_Button() throws Throwable {
        loginPage.clickLoginButton();
    }


}
