package com.myproject.swaglabsdemo.stepDefinition;

import com.myproject.swaglabsdemo.page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Miroslav Kološnjaji
 */
public class LoginStep extends BaseStep{

    private LoginPage loginPage;
    private final Queue<String> stringQueue = new ArrayDeque<>();

    @When("User opens URL {string}")
    public void userOpensURL(String url) {
        getWebDriver().get(url);
        loginPage = new LoginPage(getWebDriver());
    }

    @And("User enters email as {} and password as {}")
    public void userEntersEmailAsAndPasswordAs(String email, String password) {
        loginPage.setUsername(email);
        loginPage.setPassword(password);
    }

    @And("Click on Login")
    public void clickOnLogin() {
        loginPage.clickLogin();
    }

    @Then("Page title should be {string}")
    public void pageTitleShouldBe(String title) {

        String expectedTitle = getTitle();
        assertEquals("Title doesn't match", expectedTitle, title);

    }

    private String getTitle(){
        if(stringQueue.isEmpty())
            stringQueue.addAll(List.of("Products", "Swag Labs"));

        return stringQueue.poll();

    }

    @When("User click on burger menu")
    public void userClickOnBurgerMenu() throws InterruptedException {
        loginPage.clickOnBurgerMenu();
    }

    @When("User click on Logout link")
    public void userClickOnLogoutLink() {
        loginPage.clickLogout();
    }

}
