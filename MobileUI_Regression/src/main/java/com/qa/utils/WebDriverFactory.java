package com.qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver getDriver() {
        // Set up WebDriver configuration (e.g., ChromeDriver)
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
