package com.cybertek.Day10;

public class CSSLocatorTest {
    String button1Locator = "[onclick='button1()']";
    String button2Locator = ".btn:nth-of-type(2)";
    String button3Locator = "[id^='button_']"; // ^ means start with
    String button4Locator = "[id$='_button'][onclick='button4()']"; //$ means ends with
    String Button5Locator  = "[onclick*='5']"; // * means contains
    String Button6Locator  = "#disappearing_button"; // # id
}
