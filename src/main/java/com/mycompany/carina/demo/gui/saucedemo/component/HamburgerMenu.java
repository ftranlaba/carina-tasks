package com.mycompany.carina.demo.gui.saucedemo.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HamburgerMenu extends AbstractUIObject {
    @FindBy(xpath = "//a[contains(@id, 'sidebar_link')]")
    private List<ExtendedWebElement> linkList;

    @FindBy(xpath = "//*[@id='react-burger-menu-btn']")
    private ExtendedWebElement hamburgerMenu;

    public HamburgerMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickNavOption(String option) {
        hamburgerMenu.click();
        linkList.stream().filter(e -> e.getText().equalsIgnoreCase(option)).findFirst().get().click();
    }
}