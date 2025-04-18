package com.myproject.swaglabsdemo.stepDefinition;

import com.google.inject.Inject;
import com.myproject.swaglabsdemo.entity.User;
import com.myproject.swaglabsdemo.entity.strategy.TestDataStrategy;
import com.myproject.swaglabsdemo.page.*;
import com.myproject.swaglabsdemo.util.config.NavigationService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author Miroslav Kološnjaji
 */
public class OrderingStep {

    private User user;
    private final WebDriver webDriver;
    private final NavigationService navigationService;
    private final TestDataStrategy testDataStrategy;
    private final LoginPage loginPage;
    private ProductPage productPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;

    @Inject
    public OrderingStep(WebDriver webDriver, TestDataStrategy testDataStrategy) {
        this.webDriver = webDriver;
        this.loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        this.navigationService = PageFactory.initElements(webDriver, NavigationService.class);
        this.testDataStrategy = testDataStrategy;
    }

    @Given("generate valid user")
    public void generateValidUser() {
        user = testDataStrategy.generateTestUserData();
    }


    @When("login as valid user")
    public void loginAsValidUserWithAnd() {
        productPage = loginPage
                .setUsername(user.getUserName())
                .setPassword(user.getPassword())
                .clickLogin();

        assertFalse(loginPage.isErrorMessageDisplayed(), "Login failed.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("verify that user landed on the products page")
    public void verifyThatUserLandedOnTheProductsPage() {

        boolean isCorrectPage = productPage.isCorrectPage();

        assertTrue(isCorrectPage, "User is not on the Products page.");
    }

    @And("user add desired products to the Cart")
    public void userAddDesiredProductsToTheCart() {

        List<String> productList = List.of(
                "add-to-cart-sauce-labs-backpack",
                "add-to-cart-sauce-labs-bike-light",
                "add-to-cart-sauce-labs-bolt-t-shirt",
                "add-to-cart-sauce-labs-fleece-jacket",
                "add-to-cart-sauce-labs-onesie",
                "add-to-cart-test.allthethings()-t-shirt-(red)");

        productPage
                .addProductsToCart(productList);

    }


    @Then("verify that shopping cart contains notification with correct number")
    public void verifyThatShoppingCartContainsNotificationWithCorrectNumber() {

        Integer quantity = 6;

        boolean isCorrect = productPage.verifyShoppingCartProductCount(quantity);
        assertTrue(isCorrect, "Displayed notification is incorrect.");
    }

    @And("checkout from the Cart")
    public void checkoutFromTheCart() {
        checkoutYourInformationPage = navigationService
                .navigateToShoppingCartPage(webDriver)
                .clickCheckout();
    }

    @And("populate the form on the Your Information page")
    public void populateTheFormOnTheYourInformationPageWithFirstNameLastNameAndPostalCode() {
        checkoutOverviewPage = checkoutYourInformationPage
                .populateFirstNameField(user.getFirstName())
                .populateLastNameField(user.getLastName())
                .populatePostalCodeField(user.getPostalCode())
                .clickContinueButton();
    }


    @And("finish the order")
    public void finishTheOrder() {
        checkoutCompletePage = checkoutOverviewPage
                .clickFinishButton();

        assertTrue(checkoutCompletePage.isCorrectPage(), "");
    }

    @Then("should receive the success message")
    public void shouldReceiveTheSuccessMessage() {

        boolean isCorrectMessage = checkoutCompletePage.isSuccessMessageDisplayed();
        assertTrue(isCorrectMessage, "Success message is not displayed");
    }


}
