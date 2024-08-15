package com.saucedemo.pages;

import com.saucedemo.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    private final By cartItemCount = By.className("shopping_cart_badge");
    private final By removeButton = By.xpath("//button[text()='Remove']");
    private final By addButton = By.xpath("//button[text()='Add to cart']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting cart items count")
    public int getCartItemCount() {
        // Check if the cart item count element is present
        if (WaitUtils.isElementPresent(driver, cartItemCount)) {
            String countText = WaitUtils.waitForElementVisible(driver, cartItemCount).getText();
            return Integer.parseInt(countText);
        }
        // If the element is not found, return 0 (i.e., no items in the cart)
        return 0;
    }

    @Step("Attempting clicking to add a product to the cart")
    public void removeItemFromCart() {
        WaitUtils.waitForElementClickable(driver, removeButton).click();
    }

    @Step("Attempting clicking to remove a product from the cart")
    public void addItemToCart() {
        WaitUtils.waitForElementClickable(driver, addButton).click();
    }
}
