package com.myproject.swaglabsdemo.util.config;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.myproject.swaglabsdemo.util.driver.DriverProviderService;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;

/**
 * @author Miroslav Kološnjaji
 */
public class E2EModule extends AbstractModule {

    @Provides
    @ScenarioScoped
    @Inject
    public synchronized WebDriver provideWebDriver(){
        return DriverProviderService.getChromeDriver();
    }
}
