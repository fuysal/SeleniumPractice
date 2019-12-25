package com.cybertek.Day15_Review;

import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.TestBase;
import com.cybertek.Utilities.VYTrackUtils;
import org.testng.annotations.Test;


public class TestingTests extends TestBase {
    @Test
    public void test2 (){
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        VYTrackUtils.login(driver, username,password );
        VYTrackUtils.navigateToModules(driver,"Activities","Calendar Events");
    }
}
