package com.mycompany.carina.demo.gui.saucedemo.component;

import com.mycompany.carina.demo.gui.saucedemo.enums.SortOptions;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

public class SortBar extends AbstractUIObject {
    @FindBy(xpath = "//*[@class='product_sort_container']")
    private ExtendedWebElement sortBar;

    @FindBy(xpath = "//*[@class='active_option']")
    private ExtendedWebElement activeOption;

    public SortBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickSortOption(SortOptions param) {
        if (param.equals(SortOptions.SORT_BAR)) {
            sortBar.click();
        } else {
            sortBar.select(param.getVal());
        }
    }

    public SortOptions getCurrentOption() {
        return Arrays.stream(SortOptions.values()).filter(e -> e.getVal().equalsIgnoreCase(activeOption.getText())).findFirst().get();
    }
}
