package com.saucedemo.tests;

import com.github.javafaker.Faker;
import com.saucedemo.config.TestSettings;
import com.saucedemo.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Valid/Invalid Logging")
public class LoginTest extends BaseTest {

    @Description("Testing Valid Logging")
    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(getDriver());

        // Entering valid username and password
        boolean validLoginChecking = loginPage
                .login(TestSettings.getUserName(), TestSettings.getPassword())
                .isShoppingCartDisplayed();

        // Asserting the displaying of ShoppingCart Icon
        Assert.assertTrue(validLoginChecking, "Shopping cart should be displayed after login");
    }

    @Description("Testing Invalid Logging")
    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        Faker faker = new Faker();

        // Generate random username and password
        String invalidUsername = faker.name().username();
        String invalidPassword = faker.internet().password();

        // Perform login with invalid credentials
        loginPage.login(invalidUsername, invalidPassword);

        // Get the error message
        String errorMessage = loginPage.getErrorMessage();

        // Log the credentials used (for debugging purposes)
        System.out.println("Attempted login with username: " + invalidUsername + " and password: " + invalidPassword);

        // Assert that the error message is as expected
        Assert.assertTrue(errorMessage.contains("Epic sadface: Username and password do not match any user in this service"),
                "Error message should indicate invalid login credentials.");
    }
}
