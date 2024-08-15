package com.saucedemo.tests;

import com.saucedemo.pages.LogoutPage;
import com.saucedemo.pages.ProductsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Logging Out")
public class LogoutTest extends BaseTest {

    @Description("Testing Successful Logging Out Function")
    @Test
    public void testLogoutFunctionality() {
        new ProductsPage(getDriver()).goToProductsPageDirectly();

        LogoutPage logoutPage = new LogoutPage(getDriver());
        boolean checkingLogout = logoutPage
                .clickMenuButton()
                .clickLogoutLink()
                .isLogoutSuccessful();

        Assert.assertTrue(checkingLogout, "User should be redirected to login page after logout.");
    }
}
