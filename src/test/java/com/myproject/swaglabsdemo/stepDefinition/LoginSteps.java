package com.myproject.swaglabsdemo.stepDefinition;

import com.google.inject.Inject;
import com.myproject.swaglabsdemo.entity.strategy.TestDataStrategy;
import com.myproject.swaglabsdemo.page.LoginPage;
import com.myproject.swaglabsdemo.page.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.*;


/**
 * @author Miroslav Kološnjaji
 */
public class LoginSteps extends BaseStep{

    private final LoginPage loginPage;
    private ProductPage productPage;

    @Inject
    protected LoginSteps(WebDriver wwebdriver) {
        super(wwebdriver);
        this.loginPage = PageFactory.initElements(webDriver, LoginPage.class);
    }

    @Given("user is on the login page")
    public void userIsOnTheLoginPage(){
        assertTrue(loginPage.isCorrectPage(), "User is not landed on the Login page." );
    }

    @When("user enters username {} and password {}")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @And("clicks the login button")
    public void clicksTheLoginButton() {
        productPage = loginPage.clickLogin();
    }

    @Then("user should be redirected to the product page")
    public void userShouldBeRedirectedToTheProductPage() {
        assertTrue(productPage.isCorrectPage(), "User didn't landed on Product page");
    }

    @Then("user should expect message {}")
    public void userShouldExpectMessage(String message) {

        String actualMessage = loginPage.getErrorMessage();

        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed.");
        assertEquals(actualMessage, message, "Error message doesn't match.");
    }
}
