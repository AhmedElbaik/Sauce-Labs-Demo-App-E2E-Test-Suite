package com.saucedemo.tests;

import com.saucedemo.pages.ProductsPage;
import com.saucedemo.pages.ShoppingCartPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Shopping Cart Manipulation")
public class ShoppingCartTest extends BaseTest {

    @Description("Testing adding products to the cart successfully")
    @Test
    public void testAddToCart() {
        new ProductsPage(getDriver()).goToProductsPageDirectly();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
        shoppingCartPage.addItemToCart();
        Assert.assertEquals(shoppingCartPage.getCartItemCount(), 1, "Cart item count should be 1 after adding a product.");
    }

    @Description("Testing removing products to the cart successfully")
    @Test
    public void testRemoveFromCart() {
        new ProductsPage(getDriver()).goToProductsPageDirectly();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
        shoppingCartPage.addItemToCart();
        shoppingCartPage.removeItemFromCart();
        Assert.assertEquals(shoppingCartPage.getCartItemCount(), 0, "Cart item count should be 0 after removing a product.");
    }
}
