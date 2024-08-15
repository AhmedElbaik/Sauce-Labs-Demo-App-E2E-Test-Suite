package com.saucedemo.enums;

public final class TestConstants {
    private TestConstants() {} // Prevent instantiation

    public enum TestRunType {
        LOCAL,
        GRID
    }

    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE
    }
}
