package com.mycompany.carina.demo.gui.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CheckoutYourInformationPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final String pageUrl = "https://www.saucedemo.com/checkout-step-one.html";

    @FindBy(xpath = "//*[@id='first-name']")
    private ExtendedWebElement firstNameInput;

    @FindBy(xpath = "//*[@id='last-name']")
    private ExtendedWebElement lastNameInput;

    @FindBy(xpath = "//*[@id='postal-code']")
    private ExtendedWebElement postalCodeInput;

    @FindBy(xpath = "//*[@id='continue']")
    private ExtendedWebElement continueButton;

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(pageUrl);
    }

    public void typeFirstNameInput(String firstName) {
        firstNameInput.type(firstName);
    }

    public void typeLastNameInput(String lastName) {
        lastNameInput.type(lastName);
    }

    public void typePostalCodeInput(String postalCode) {
        postalCodeInput.type(postalCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

}
