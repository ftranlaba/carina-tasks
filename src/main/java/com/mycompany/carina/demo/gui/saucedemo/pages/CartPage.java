package com.mycompany.carina.demo.gui.saucedemo.pages;

import com.mycompany.carina.demo.gui.saucedemo.component.ProductItem;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class CartPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final String cartPageUrl = "https://www.saucedemo.com/cart.html";

    @FindBy(className = "cart_item")
    private List<ProductItem> products;

    @FindBy(className = "shopping_cart_container")
    private ExtendedWebElement shoppingCartIconButton;

    @FindBy(xpath = "//*[@id='checkout']")
    private ExtendedWebElement checkOutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(cartPageUrl);
    }

    public void clickProductRemoveFromCart(String product) {
        findProductByName(product).clickRemoveButton();
    }

    public Boolean isShoppingCartIconPresent() {
        return shoppingCartIconButton.isElementPresent();
    }

    public ProductItem findProductByName(String name) {
        return products.stream().filter(e -> e.readProductName().equalsIgnoreCase(name)).findFirst().get();
    }

    public int getShoppingCartAmount() {
        return products.size();
    }

    public void clickCheckOutButton() {
        checkOutButton.click();
    }


}
