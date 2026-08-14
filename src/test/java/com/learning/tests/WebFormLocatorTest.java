package com.learning.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebFormLocatorTest {

    @Test
    public void fillWebFormAndVerifyMessage() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            // Find the text field using its name attribute
            WebElement textBox = driver.findElement(By.name("my-text"));

            // Find the Submit button using a CSS selector
            WebElement submitButton = driver.findElement(By.cssSelector("button"));

            // Type text into the field
            textBox.sendKeys("Testing selenium locators");
            // Click Submit
            submitButton.click();

            // Find the success message using its id attribute
            WebElement message = driver.findElement(By.id("message"));

            // Verify the expected result
            Assert.assertEquals(message.getText(), "Received!");

        } finally {
            driver.quit();
        }
    }
}