package com.myproject.swaglabsdemo.page;

import com.myproject.swaglabsdemo.util.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Miroslav Kološnjaji
 */
public class CheckoutOverviewPage extends BasePage {

    private static final String TITLE = "Checkout: Overview";

    @FindBy(how = How.ID, using = "finish")
    @CacheLookup
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutCompletePage clickFinishButton() {
        WebDriverUtils.isClicable(finishButton);
        finishButton.click();
        return PageFactory.initElements(webDriver, CheckoutCompletePage.class);
    }

    public boolean isCorrectPage() {
        return isCorrectPage(TITLE);
    }
}
