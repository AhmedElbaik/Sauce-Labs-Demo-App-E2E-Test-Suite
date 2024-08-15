package com.saucedemo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {
    private static final long TIMEOUT = 10;

    public static WebElement waitForElementVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static List<WebElement> waitForElementsVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static WebElement waitForElementClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            // Use a short wait to check for the element's presence
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

}