package com.mycompany.carina.demo.gui.saucedemo.exceptions;

public class ProductOptionDoesNotExistException extends RuntimeException {
    public ProductOptionDoesNotExistException(String errorMsg) {
        super(errorMsg);
    }
}