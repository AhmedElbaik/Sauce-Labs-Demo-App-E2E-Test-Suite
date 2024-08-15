package com.saucedemo.tests;

import com.saucedemo.pages.ProductsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Feature("Products Manipulation")
public class ProductsTest extends BaseTest {

    @Description("Testing that all products are successfully displayed")
    @Test
    public void testAllProductsDisplayed() {
        ProductsPage productsPage = new ProductsPage(getDriver()).goToProductsPageDirectly();
        Assert.assertFalse(productsPage.getProductNames().isEmpty(), "Products should be displayed.");
    }

    @Description("Testing that all products details are successfully displayed")
    @Test
    public void testProductDetails() {
        ProductsPage productsPage = new ProductsPage(getDriver()).goToProductsPageDirectly();
        Assert.assertFalse(productsPage.getProductPrices().isEmpty(), "Product prices should be displayed.");
    }

    @Description("Testing sorting products are successfully functioning")
    @Test
    public void testSortingFunctionality() {
        ProductsPage productsPage = new ProductsPage(getDriver()).goToProductsPageDirectly();

        // Sort products by "Price (low to high)"
        productsPage.sortProductsBy("Price (low to high)");

        // Retrieve the list of product prices after sorting
        List<String> productPrices = productsPage.getProductPrices();

        // Verify that the prices are sorted in ascending order
        for (int i = 0; i < productPrices.size() - 1; i++) {
            double price1 = Double.parseDouble(productPrices.get(i).replace("$", ""));
            double price2 = Double.parseDouble(productPrices.get(i + 1).replace("$", ""));

            Assert.assertTrue(price1 <= price2,
                    "Products are not sorted by price correctly. Found " + price1 + " before " + price2);
        }
    }

}
