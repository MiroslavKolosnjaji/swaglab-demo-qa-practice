package com.myproject.swaglabsdemo.util.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;

import java.util.Optional;

/**
 * @author Miroslav Kološnjaji
 */
public class E2EInjector implements InjectorSource {

    private static Injector injector;

    @Override
    public Injector getInjector() {

        if (injector != null)
            return injector;

        return Guice.createInjector(Stage.PRODUCTION, CucumberModules.createScenarioModule(), new E2EModule());
    }
}
