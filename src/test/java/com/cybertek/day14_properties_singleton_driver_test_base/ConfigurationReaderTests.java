package com.cybertek.day14_properties_singleton_driver_test_base;

import com.cybertek.Utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigurationReaderTests {
    @Test
    public void test1(){

        String expected = "chrome";
        String actual = ConfigurationReader.getProperty("browser");

        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test2(){

        String expectedUser = "storemanager";
        String actualUser = ConfigurationReader.getProperty("username");
        Assert.assertEquals(actualUser,expectedUser);
    }

}
