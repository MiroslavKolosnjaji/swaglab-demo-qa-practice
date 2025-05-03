package com.myproject.swaglabsdemo.runner;

import com.myproject.swaglabsdemo.util.config.BrowserContext;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * @author Miroslav Kološnjaji
 */
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com/myproject/swaglabsdemo/stepDefinition", "com/myproject/swaglabsdemo/hook"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests{

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser){
        BrowserContext.setBrowser(browser);
    }
}
