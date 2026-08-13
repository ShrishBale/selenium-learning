package com.learning.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    @Test
    public void openGoogleAndCheckTitle() {

        // Opens a new Chrome browser window
        WebDriver driver = new ChromeDriver();

        try {
            // Opens Google
            driver.get("https://www.google.com");

            // Reads the page title
            String actualTitle = driver.getTitle();

            // Checks that the title contains the word Google
            Assert.assertTrue(actualTitle.contains("Google"));

            System.out.println("Test passed. Page title: " + actualTitle);

        } finally {
            // Always closes the browser, even if the test fails
            driver.quit();
        }
    }
}