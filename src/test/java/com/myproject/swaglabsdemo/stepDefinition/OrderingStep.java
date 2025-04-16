package com.myproject.swaglabsdemo.stepDefinition;

import com.google.inject.Inject;
import com.myproject.swaglabsdemo.entity.User;
import com.myproject.swaglabsdemo.page.*;
import com.myproject.swaglabsdemo.util.config.NavigationService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

/**
 * @author Miroslav Kološnjaji
 */
public class OrderingStep {

    private WebDriver webDriver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;
    private NavigationService navigationService;

    @Inject
    public OrderingStep(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        this.productPage = PageFactory.initElements(webDriver, ProductPage.class);
        this.checkoutYourInformationPage = PageFactory.initElements(webDriver, CheckoutYourInformationPage.class);
        this.checkoutOverviewPage = PageFactory.initElements(webDriver, CheckoutOverviewPage.class);
        this.checkoutCompletePage = PageFactory.initElements(webDriver, CheckoutCompletePage.class);
        this.navigationService = PageFactory.initElements(webDriver, NavigationService.class);
    }

    @Given("generate valid user")
    public void generateValidUser() {
        User user = User.builder()
                .userName("standard_user")
                .password("secret_sauce")
                .firstName("John")
                .lastName("Smith")
                .postalCode("25234")
                .build();
    }


    @When("login as valid user with {string} and {string}")
    public void loginAsValidUserWithAnd(String userName, String password) {
        loginPage
                .setUsername(userName)
                .setPassword(password)
                .clickLogin();
    }

    @Then("verify that user landed on the products page")
    public void verifyThatUserLandedOnTheProductsPage() {

        boolean isCorrectPage = productPage.isCorrectPage();
        assertTrue(isCorrectPage, "User is not on the Products page.");
    }

    @And("user add desired products to the Cart")
    public void userAddDesiredProductsToTheCart() {

        productPage
                .addBackPackProductToCart()
                .addBikeLightProductTOCart()
                .addBoltTShirtProductToCart()
                .addFleeceJacketProductToCart()
                .addOnesieProductToCart()
                .addRedTShirtProductToCart();
    }

    @Then("verify that shopping cart contains notification with correct number")
    public void verifyThatShoppingCartContainsNotificationWithCorrectNumber() {

        boolean isCorrect = productPage.verifyShoppingCartProductCount();
        assertTrue(isCorrect, "Displayed notification is incorrect.");
    }

    @And("checkout from the Cart")
    public void checkoutFromTheCart() {
        navigationService
                .navigateToShoppingCartPage(webDriver)
                .clickCheckout();
    }

    @And("populate the form on the Your Information page with first name {string}, last name {string}, and postal code {string}")
    public void populateTheFormOnTheYourInformationPageWithFirstNameLastNameAndPostalCode(String... credentials) {
        checkoutYourInformationPage
                .populateFirstNameField(credentials[0])
                .populateLastNameField(credentials[1])
                .populatePostalCodeField(credentials[2])
                .clickContinueButton();
    }


    @And("finish the order")
    public void finishTheOrder() {
        checkoutOverviewPage
                .clickFinishButton();
    }

    @Then("should receive the success message")
    public void shouldReceiveTheSuccessMessage() {

        boolean isCorrectMessage = checkoutCompletePage.isSucessmessageDisplayed();
        assertTrue(isCorrectMessage, "Success message is not displayed");
    }


}
