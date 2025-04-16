package com.myproject.swaglabsdemo.page;

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

    private final String TITLE = "Checkout: Overview";

    @FindBy(how = How.ID, using = "finish")
    @CacheLookup
    private WebElement finishButton;

    protected CheckoutOverviewPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutCompletePage clickFinishButton() {
        finishButton.click();
        return PageFactory.initElements(webDriver, CheckoutCompletePage.class);
    }

    @Override
    public boolean isCorrectPage() {
        return webDriver.findElement(By.xpath(XPATH_TO_PAGE_TITLE)).getText().equals(TITLE);
    }
}
