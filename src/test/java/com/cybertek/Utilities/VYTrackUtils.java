package com.cybertek.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class VYTrackUtils {
    private static String usernameLocator = "prependedInput";
    private static String passwordLocator = "prependedInput2";

    /**
     * Login ino vytrack app
     * @param driver
     * @param username
     * @param password
     */


    public static void login(WebDriver driver, String username, String password) {
        driver.findElement(By.id(username)).sendKeys(username);
        driver.findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);

    }

}
