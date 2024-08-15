package com.saucedemo.pages;

import com.saucedemo.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

public class LogoutPage extends BasePage {

    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Attempting clicking on menu button")
    public LogoutPage clickMenuButton() {
        WaitUtils.waitForElementClickable(driver, menuButton).click();
        return this;
    }

    @Step("Attempting clicking on logout button")
    public LogoutPage clickLogoutLink() {
        int maxRetries = 5;
        int attempt = 0;
        boolean clicked = false;

        while (attempt < maxRetries && !clicked) {
            try {
                // Try to click on the logout link
                WebElement element = WaitUtils.waitForElementClickable(driver, logoutLink);
                element.click();
                clicked = true; // Set flag to true if click is successful
            } catch (ElementClickInterceptedException e) {
                // If the click is intercepted, wait for a short duration and retry
                System.out.println("Click intercepted, retrying... Attempt " + (attempt + 1));
                attempt++;
                try {
                    Thread.sleep(1000); // Wait for a short period before retrying
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt(); // Restore interrupted status
                }
            } catch (NoSuchElementException e) {
                // If the element is not found, break out of the loop
                System.out.println("Logout link not found, cannot proceed.");
                throw e; // Re-throw the exception to fail the test if needed
            }
        }

        if (!clicked) {
            throw new RuntimeException("Failed to click on the logout link after " + maxRetries + " attempts.");
        }

        return this;
    }

    @Step("Checking if the login button displayed")
    public boolean isLogoutSuccessful() {
        return WaitUtils.isElementPresent(driver, By.id("login-button"));
    }
}
