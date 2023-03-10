package com.mycompany.carina.demo.mytests;

import com.mycompany.carina.demo.gui.saucedemo.pages.LoginPage;
import com.mycompany.carina.demo.gui.saucedemo.pages.ProductPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class UtilTest implements ICustomTypePageFactory {
    private static String username = "standard_user";
    private static String password = "secret_sauce";

    protected ProductPage login(String username, String password) {
        LoginPage login = new LoginPage(getDriver());
        login.open();
        login.typeUsername(username);
        login.typePassword(password);
        login.login();
        return new ProductPage(getDriver());
    }

    protected ProductPage login() {
        LoginPage login = new LoginPage(getDriver());
        login.open();
        login.typeUsername(username);
        login.typePassword(password);
        login.login();
        return new ProductPage(getDriver());
    }
}
