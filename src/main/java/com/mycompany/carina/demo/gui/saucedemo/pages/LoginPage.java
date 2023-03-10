package com.mycompany.carina.demo.gui.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final String loginPageUrl = "https://www.saucedemo.com/";

    @FindBy(xpath = "//*[@id='user-name']")
    private ExtendedWebElement usernameInput;

    @FindBy(xpath = "//*[@id='password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//*[@id='login-button']")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(loginPageUrl);
    }

    public void typeUsername(String username) {
        usernameInput.type(username);
    }

    public void typePassword(String password) {
        passwordInput.type(password);
    }

    public void login() {
        loginButton.clickIfPresent();
    }

}
