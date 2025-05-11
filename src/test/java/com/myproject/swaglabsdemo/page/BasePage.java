package com.myproject.swaglabsdemo.page;

import com.google.inject.Inject;
import com.myproject.swaglabsdemo.util.PageLoaderHelper;
import com.myproject.swaglabsdemo.util.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * @author Miroslav Kološnjaji
 */

public abstract class BasePage {

    protected static final String XPATH_TO_PAGE_TITLE = "//span[@class='title']";
    protected final WebDriver webDriver;

    @Inject
    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageLoaderHelper.waitForPageToLoad(webDriver, 10);
    }

    protected boolean isCorrectPage(String title) {
        WebDriverUtils.isDisplayed(getPageTitle());
        return getPageTitle().getText().equals(title);
    }

    private WebElement getPageTitle() {
        return webDriver.findElement(By.xpath(XPATH_TO_PAGE_TITLE));
    }
}
