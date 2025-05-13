package com.myproject.swaglabsdemo.stepDefinition;

import com.google.inject.Inject;
import com.myproject.swaglabsdemo.page.LoginPage;
import com.myproject.swaglabsdemo.page.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

/**
 * @author Miroslav Kološnjaji
 */
public class LogoutSteps extends BaseStep{

    @Inject
    protected LogoutSteps(WebDriver webDriver) {
        super(webDriver);
    }

    @When("user open hamburger menu")
    public void userOpenHamburgerMenu() {
        productPage.selectHamburgerMenu();
    }

    @And("clicks the Logout link")
    public void clicksTheLogoutLink() {
       loginPage =  productPage.logout();
    }

    @Then("user should be redirected to the login page")
    public void userShouldBeRedirectedToTheLoginPage() {

        assertTrue(loginPage.isCorrectPage(), "User is not redirected to the login page");
    }
}
