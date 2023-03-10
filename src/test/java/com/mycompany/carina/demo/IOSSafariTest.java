package com.mycompany.carina.demo;

import com.mycompany.carina.demo.mobile.gui.pages.ios.SaucePage;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.Test;

public class IOSSafariTest implements IAbstractTest, IMobileUtils {
    @Test
    public void safariTest() {
        SaucePage saucePage = new SaucePage(getDriver());
        saucePage.openURL("http://saucelabs.com/test/guinea-pig");
        saucePage.verifyElementText();
        saucePage.sendComment();
    }

}