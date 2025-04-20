package com.myproject.swaglabsdemo.page;

import com.myproject.swaglabsdemo.util.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Miroslav Kološnjaji
 */
@Slf4j
public class CheckoutOverviewPage extends BasePage {

    private static final String TITLE = "Checkout: Overview";

    @FindBy(how = How.ID, using = "finish")
    @CacheLookup
    private WebElement finishButton;

    @FindBy(how = How.CLASS_NAME, using = "summary_info")
    @CacheLookup
    private WebElement summaryInfoLabel;

    public CheckoutOverviewPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutCompletePage clickFinishButton() {
        WebDriverUtils.isClicable(finishButton);
        finishButton.click();
        return PageFactory.initElements(webDriver, CheckoutCompletePage.class);
    }

    public Map<String, String> summaryInfo() {

        Map<String, String> summaryMap = new HashMap<>();

        WebDriverUtils.waitUntilVisible(summaryInfoLabel);

        WebElement subtotalLabel = findElement(summaryInfoLabel,"[data-test = 'subtotal-label']");
        WebElement taxLabel = findElement(summaryInfoLabel,"[data-test = 'tax-label']");
        WebElement totalLabel = findElement(summaryInfoLabel,"[data-test = 'total-label']");

        summaryMap.put("subtotal", extractPriceFromLabel(subtotalLabel, 2));
        summaryMap.put("tax", extractPriceFromLabel(taxLabel,1));
        summaryMap.put("total", extractPriceFromLabel(totalLabel,1));

        log.info("Item price: {}", summaryMap.get("subtotal"));
        log.info("Tax: {}", summaryMap.get("tax"));
        log.info("Total price: {}", summaryMap.get("total"));

        return summaryMap;
    }

    public boolean isCorrectPage() {
        return isCorrectPage(TITLE);
    }

    private WebElement findElement(WebElement element, String cssSelector){
        return element.findElement(By.cssSelector(cssSelector));
    }

    private String extractPriceFromLabel(WebElement element, int index){
        return element.getText().split(" ")[index];
    }
}
