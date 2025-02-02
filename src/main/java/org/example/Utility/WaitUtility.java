package org.example.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WaitUtility extends Utility{


    public static void fluentWaitUntilVisible(By locator, int seconds) {
        // Create a FluentWait instance with the specified timeout and polling frequency
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchFieldException.class, StaleElementReferenceException.class);

        // Wait until the specified element is visible
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

