package com.myproject.swaglabsdemo.util.config;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.myproject.swaglabsdemo.entity.strategy.TestDataStrategy;
import com.myproject.swaglabsdemo.entity.strategy.impl.ValidUserStrategy;
import com.myproject.swaglabsdemo.stepDefinition.OrderingStep;
import com.myproject.swaglabsdemo.util.WebDriverUtils;
import com.myproject.swaglabsdemo.util.driver.DriverProviderService;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

/**
 * @author Miroslav Kološnjaji
 */
public class E2EModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(OrderingStep.class).in(ScenarioScoped.class);
        super.configure();
    }

    @Provides
    @ScenarioScoped
    @Inject
    public synchronized WebDriver provideWebDriver() {

        String browserName = System.getProperty("browser", "chrome");
        WebDriver webDriver = DriverProviderService.getWebDriver(DriverProviderService.BrowserType.fromString(browserName));

        WebDriverUtils.createInstance(webDriver, Duration.ofSeconds(10));

        webDriver.manage().window().maximize();


        return webDriver;
    }

    @Provides
    @ScenarioScoped
    @Inject
    public synchronized TestDataStrategy provideUserData() {
        return new ValidUserStrategy();
    }
}
