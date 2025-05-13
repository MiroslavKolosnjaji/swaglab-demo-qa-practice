package com.myproject.swaglabsdemo.stepDefinition;

import com.myproject.swaglabsdemo.entity.User;
import com.myproject.swaglabsdemo.entity.strategy.TestDataStrategy;
import com.myproject.swaglabsdemo.page.*;
import com.myproject.swaglabsdemo.util.config.NavigationService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Miroslav Kološnjaji
 */
public abstract class BaseStep {

    protected User user;
    protected final WebDriver webDriver;
    protected final NavigationService navigationService;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CheckoutYourInformationPage checkoutYourInformationPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;

    protected BaseStep(WebDriver webDriver) {
        this.loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        this.productPage = PageFactory.initElements(webDriver, ProductPage.class);
        this.navigationService = PageFactory.initElements(webDriver, NavigationService.class);
        this.webDriver = webDriver;
    }
}
