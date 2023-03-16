package com.mycompany.carina.demo.mytests;

import com.mycompany.carina.demo.gui.saucedemo.enums.SortOptions;
import com.mycompany.carina.demo.gui.saucedemo.pages.CartPage;
import com.mycompany.carina.demo.gui.saucedemo.pages.CheckoutYourInformationPage;
import com.mycompany.carina.demo.gui.saucedemo.pages.ProductPage;
import com.mycompany.carina.demo.gui.saucedemo.pages.SauceLabsPage;
import com.mycompany.carina.demo.gui.saucedemo.pages.checkout.CheckoutCompletePage;
import com.mycompany.carina.demo.gui.saucedemo.pages.checkout.CheckoutOverviewPage;
import com.mycompany.carina.demo.utils.AuthUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest extends AbstractSauceDemoTest {
    @Test
    public void testSort() {
        ProductPage productPage = authUtils.loginAsStandardUser();
        productPage.setSortOption(SortOptions.LOW_TO_HIGH);
        Assert.assertEquals(productPage.getSortActiveOption(), SortOptions.LOW_TO_HIGH, "Sort Bar active option is not low to high.");
    }

    @Test
    public void testAboutPage() {
        ProductPage productPage = authUtils.loginAsStandardUser();
        productPage.navigate("About");
        SauceLabsPage sauceLabsPage = new SauceLabsPage((getDriver()));
        Assert.assertTrue(sauceLabsPage.isPageOpened(), "Sauce labs page is not opened!");
    }

    @Test
    public void testAddCart() {
        String product = "Sauce Labs Backpack";
        ProductPage productPage = authUtils.loginAsStandardUser();
        productPage.clickProductAddToCart(product);
        productPage.clickShoppingCart();
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertEquals(cartPage.findProductByName(product).getProductName(), product, "Unable to find product in cart page.");
    }

    @Test
    public void testRemoveCart() {
        String product = "Sauce Labs Backpack";
        ProductPage productPage = authUtils.loginAsStandardUser();
        productPage.clickProductAddToCart(product);
        CartPage cartPage = productPage.clickShoppingCart();
        cartPage.clickProductRemoveFromCart(product);
        Assert.assertEquals(cartPage.getProductsCount(), 0, "Unable to remove product in cart page.");
    }

    @Test
    public void testCheckout() {
        String product = "Sauce Labs Backpack";
        ProductPage productPage = authUtils.loginAsStandardUser();
        productPage.clickProductAddToCart(product);
        productPage.clickShoppingCart();
        CartPage cartPage = new CartPage(getDriver());
        cartPage.clickCheckOutButton();
        CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(getDriver());
        checkoutYourInformationPage.typeFirstNameInput(randomUtils.getRandomString());
        checkoutYourInformationPage.typeLastNameInput(randomUtils.getRandomNumber(1, 10) + "");
        checkoutYourInformationPage.typePostalCodeInput("12345");
        checkoutYourInformationPage.clickContinueButton();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(getDriver());
        Assert.assertEquals(checkoutOverviewPage.getProductsCount(), 1, "Incorrect amount of products found.");
        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isPageOpened(), "Checkout is not complete!");
    }

}
