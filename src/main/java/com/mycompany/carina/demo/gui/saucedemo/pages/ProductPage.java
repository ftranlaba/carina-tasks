package com.mycompany.carina.demo.gui.saucedemo.pages;

import com.mycompany.carina.demo.gui.saucedemo.component.HamburgerMenu;
import com.mycompany.carina.demo.gui.saucedemo.component.ProductItem;
import com.mycompany.carina.demo.gui.saucedemo.component.SortBar;
import com.mycompany.carina.demo.gui.saucedemo.enums.SortOptions;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class ProductPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@class='product_sort_container']")
    private SortBar sortBar;

    @FindBy(xpath = "//*[@class='bm-menu-wrap']")
    private HamburgerMenu hamburgerMenu;

    @FindBy(className = "inventory_item")
    private List<ProductItem> products;

    @FindBy(className = "shopping_cart_container")
    private ExtendedWebElement shoppingCartIconButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void setSortOption(SortOptions param) {
        sortBar.clickSortOption(SortOptions.SORT_BAR);
        sortBar.clickSortOption(param);
    }

    public void navigate(String param) {
        hamburgerMenu.clickNavOption(param);
    }

    public SortOptions getSortActiveOption() {
        return sortBar.getCurrentOption();
    }

    public void clickProductAddToCart(String product) {
        findProductByName(product).clickAddToCartButton();
    }

    public void clickProductRemoveFromCart(String product) {
        findProductByName(product).clickRemoveButton();
    }

    public void clickShoppingCart() {
        shoppingCartIconButton.click();
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

}
