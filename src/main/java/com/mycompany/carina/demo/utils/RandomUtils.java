package com.mycompany.carina.demo.utils;

import com.mycompany.carina.demo.gui.saucedemo.pages.LoginPage;
import com.mycompany.carina.demo.gui.saucedemo.pages.ProductPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils implements ICustomTypePageFactory {
    public String getRandomString(){
        return RandomStringUtils.randomAlphabetic(10);
    }

    public int getRandomNumber(int min, int max){
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

}
