package com.myproject.swaglabsdemo.util.config;

/**
 * @author Miroslav Kološnjaji
 */
public class BrowserContext {
    private static final ThreadLocal<String> browser = new ThreadLocal<>();

    public static void setBrowser(String browserName){
        browser.set(browserName);
    }

    public static String getBrowser(){
        return browser.get();
    }
}
