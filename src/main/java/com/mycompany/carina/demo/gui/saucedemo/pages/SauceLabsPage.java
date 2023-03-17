package com.mycompany.carina.demo.gui.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SauceLabsPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final String sauceLabsUrl = "https://www.saucelabs.com/";

    @FindBy(className = "css-chbenk")
    private ExtendedWebElement tryItFreeRow;

    public SauceLabsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(sauceLabsUrl);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(tryItFreeRow);
    }

}
