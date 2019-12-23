package com.cybertek.day14_properties_singleton_driver_test_base;

import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.Driver;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    LoginPage loginPage = new LoginPage();
    @Test
    public void loginTest1(){
    String username = ConfigurationReader.getProperty("username");
    String password = ConfigurationReader.getProperty("password");
    loginPage.login(username,password);

    }

}
