package com.myproject.swaglabsdemo.stepDefinition;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


import static org.testng.Assert.*;


/**
 * @author Miroslav Kološnjaji
 */
public class LoginSteps extends BaseStep{

    @Inject
    protected LoginSteps(WebDriver webdriver) {
        super(webdriver);
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
