package com.myproject.swaglabsdemo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * @author Miroslav Kološnjaji
 */
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com/myproject/swaglabsdemo/stepDefinition", "com/myproject/swaglabsdemo/hook"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests{
}
