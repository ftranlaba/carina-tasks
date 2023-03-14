package com.mycompany.carina.demo.gui.saucedemo.pages.checkout;

import com.mycompany.carina.demo.gui.saucedemo.component.ProductItem;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class CheckoutOverviewPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final String pageUrl = "https://www.saucedemo.com/checkout-step-one.html";

    @FindBy(xpath = "//*[@id='finish']")
    private ExtendedWebElement finishButton;

    @FindBy(className = "cart_item")
    private List<ProductItem> products;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(pageUrl);
    }

    public CheckoutCompletePage clickFinishButton() {
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }

    public int getProductsCount() {
        return products.size();
    }
}
