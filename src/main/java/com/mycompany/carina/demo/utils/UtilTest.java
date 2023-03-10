package com.mycompany.carina.demo.utils;

import com.mycompany.carina.demo.gui.saucedemo.pages.LoginPage;
import com.mycompany.carina.demo.gui.saucedemo.pages.ProductPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
// move to utils
public class UtilTest implements ICustomTypePageFactory {
    private static String username = "standard_user";
    private static String password = "secret_sauce";

    public ProductPage loginAsStandardUser(String username, String password) {
        LoginPage login = new LoginPage(getDriver());
        login.open();
        login.typeUsername(username);
        login.typePassword(password);
        login.login();
        return new ProductPage(getDriver());
    }

    public ProductPage loginAsStandardUser() {
        return loginAsStandardUser(R.TESTDATA.get("test_username"), R.TESTDATA.get("test_password"));
    }

    public String getSampleNameData(){
        return "SomeName";
    }

    public int getSampleNumberData(){
        return 10;
    }

}