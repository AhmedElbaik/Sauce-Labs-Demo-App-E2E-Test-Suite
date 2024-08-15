package com.saucedemo.pages;

import com.saucedemo.models.Product;
import com.saucedemo.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    private final By shoppingCartIcon = By.cssSelector("[data-test='shopping-cart-link']");
    private final By productItems = By.cssSelector(".inventory_item");
    private final By productNames = By.className("inventory_item_name");
    private final By productPrices = By.className("inventory_item_price");
    private final By sortDropdown = By.className("product_sort_container");
    private final By productPrice = By.className("inventory_item_price");
    private final By addToCartButton = By.cssSelector(".btn_inventory");

    // Constructor with WebDriver parameter
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigating directly to products page using auth cookies injection")
    // Method to bypass login and go directly to the Products page
    public ProductsPage goToProductsPageDirectly() {
        // Navigate to the base URL (could be the login page)
        driver.get("https://www.saucedemo.com/");

        // Set the session cookies if previously stored
        driver.manage().deleteAllCookies(); // Clear existing cookies first

        // Extend the expiry date to a future date (e.g., 30 days from now)
        Instant now = Instant.now();
        Instant extendedExpiry = now.plus(30, ChronoUnit.DAYS); // 30 days from now
        Date expiryDate = Date.from(extendedExpiry);

        // Add the cookies manually with an extended expiry date
        Cookie sessionCookie = new Cookie.Builder("session-username", "standard_user")
                .expiresOn(expiryDate) // Set the expiration date
                .build();

        driver.manage().addCookie(sessionCookie);

        // Now navigate directly to the products page
        String PRODUCTS_PAGE_URL = "https://www.saucedemo.com/inventory.html";
        driver.get(PRODUCTS_PAGE_URL);

        return this;
    }

    @Step("Checking if the shopping cart icon displayed")
    public boolean isShoppingCartDisplayed() {
        return WaitUtils.waitForElementVisible(driver, shoppingCartIcon).isDisplayed();
    }

    @Step("Getting products names")
    public List<String> getProductNames() {
        return WaitUtils.waitForElementsVisible(driver, productNames)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Getting products Prices")
    public List<String> getProductPrices() {
        return WaitUtils.waitForElementsVisible(driver, productPrices)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Sorting products By some option")
    public void sortProductsBy(String option) {
        WaitUtils.waitForElementClickable(driver, sortDropdown).sendKeys(option);
    }

}
