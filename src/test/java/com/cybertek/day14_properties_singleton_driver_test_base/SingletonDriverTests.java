package com.cybertek.day14_properties_singleton_driver_test_base;

import com.cybertek.Utilities.Driver;
import org.testng.annotations.Test;

public class SingletonDriverTests {
    @Test
    public void driverTest1(){
        Driver.getDriver().get("https://amazon.com");
        Driver.closeDriver();
    }
}
