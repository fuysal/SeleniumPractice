package com.cybertek.day14_properties_singleton_driver_test_base;

import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;

public class LoginPage {
    String usernameLocator = "prependedInput";
    String passwordLocator = "prependedInput2" ;
    String loginButtonLocator = "_submit";

    public void login(String username, String password){
        Driver.getDriver().findElement(By.id(usernameLocator)).sendKeys(username);
        Driver.getDriver().findElement(By.id(passwordLocator)).sendKeys(password);
        Driver.getDriver().findElement(By.id(loginButtonLocator)).click();

    }

}
