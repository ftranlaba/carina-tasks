package com.mycompany.carina.demo;

import com.mycompany.carina.demo.mobile.gui.pages.ios.PreferencesPage;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class IOSPreferencesTest implements IAbstractTest, IMobileUtils {

    @Test
    public void nativePreferencesTest() {
        WebDriver driver = getDriver();
        PreferencesPage preferencesPage = new PreferencesPage(driver);
        preferencesPage.clickGeneralBtn();
        driver.navigate().back();
    }

}