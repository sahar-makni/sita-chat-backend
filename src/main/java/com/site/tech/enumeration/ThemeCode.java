package com.site.tech.enumeration;

public enum ThemeCode {
    ARYA_BLUE("ARYA-BLUE"),
    SAGA_BLUE("SAGA-BLUE");

    private final String value;

    ThemeCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
