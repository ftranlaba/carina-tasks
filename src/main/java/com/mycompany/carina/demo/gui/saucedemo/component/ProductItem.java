package com.mycompany.carina.demo.gui.saucedemo.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject {
    @FindBy(xpath = "//button[text()='Remove']")
    private ExtendedWebElement removeButton;

    @FindBy(xpath = "//button[text()='Add to cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    private ExtendedWebElement itemName;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getProductName() {
        return itemName.getText();
    }
}
