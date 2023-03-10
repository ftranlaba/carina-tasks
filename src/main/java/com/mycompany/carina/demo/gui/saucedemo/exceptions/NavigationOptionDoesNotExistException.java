package com.mycompany.carina.demo.gui.saucedemo.exceptions;

public class NavigationOptionDoesNotExistException extends RuntimeException {
    public NavigationOptionDoesNotExistException(String errorMsg) {
        super(errorMsg);
    }
}
