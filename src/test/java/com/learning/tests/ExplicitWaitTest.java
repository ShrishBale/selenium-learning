package com.learning.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitTest {

    @Test
    public void waitForHiddenFieldThenTypeText() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

            // Click a button that reveals a hidden text field
            driver.findElement(By.id("reveal")).click();

            // Wait up to 5 seconds until that field becomes visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement revealedTextBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("revealed"))
            );

            // Type only after the field is visible
            revealedTextBox.sendKeys("I learned explicit waits!");

            Assert.assertEquals(
                    revealedTextBox.getAttribute("value"),
                    "I learned explicit waits!"
            );

        } finally {
            driver.quit();
        }
    }
}
