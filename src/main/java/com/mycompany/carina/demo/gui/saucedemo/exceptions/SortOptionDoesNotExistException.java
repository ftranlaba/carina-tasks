package com.mycompany.carina.demo.gui.saucedemo.exceptions;

public class SortOptionDoesNotExistException extends RuntimeException {
    public SortOptionDoesNotExistException(String errorMsg) {
        super(errorMsg);
    }
}