package com.mycompany.carina.demo.gui.saucedemo.enums;

public enum SortOptions {
    NAME_A_TO_Z("Name (A to Z)"),
    NAME_Z_TO_A("Name (Z to A)"),
    HIGH_TO_LOW("Price (high to low)"),
    LOW_TO_HIGH("Price (low to high)"),
    SORT_BAR("");

    private final String val;

    SortOptions(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
