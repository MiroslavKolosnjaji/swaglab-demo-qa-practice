package com.myproject.swaglabsdemo.hook;

import com.google.inject.Inject;
import com.myproject.swaglabsdemo.util.config.NavigationService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

/**
 * @author Miroslav Kološnjaji
 */
@Slf4j
public class Hook {

    private final WebDriver webDriver;

    @Inject
    public Hook(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Before
    public void setUp() {
        openLoginPage();
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }

    private void openLoginPage() {

        for (int i = 0; i < 5; i++)
            if (isOpen())
                break;

    }


    public boolean isOpen() {

        boolean isOpen = false;

        try {
            NavigationService.openLoginPage(webDriver);
            isOpen = true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return isOpen && webDriver.getTitle().equals("Swag Labs");
    }

}
