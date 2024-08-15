package com.saucedemo.pages;

import com.saucedemo.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        WaitUtils.waitForElementVisible(driver, usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        WaitUtils.waitForElementVisible(driver, passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        WaitUtils.waitForElementClickable(driver, loginButton).click();
    }

    @Step("Getting error message and after using invalid credentials for login")
    public String getErrorMessage() {
        return WaitUtils.waitForElementVisible(driver, errorMessage).getText();
    }

    @Step("Login using Valid Username and Password")
    public ProductsPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new ProductsPage(driver);
    }
}