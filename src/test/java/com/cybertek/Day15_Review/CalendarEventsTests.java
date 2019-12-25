package com.cybertek.Day15_Review;

import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.TestBase;
import com.cybertek.Utilities.VYTrackUtils;
import com.cybertek._pages.vytrack.CalendarEventsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CalendarEventsTests extends TestBase {
    CalendarEventsPage calendarPage =  new CalendarEventsPage();
    @Test
    public void test1(){
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        VYTrackUtils.login(driver, username, password);
        VYTrackUtils.navigateToModules(driver,"Activities", "Calendar Events");
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.createCalendarEventsLocator)).click();
        driver.findElement(By.cssSelector(calendarPage.repeatCheckBoxLocator)).click();
        List<String> expectedOptions = Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List <String> actualOptions = calendarPage.getRepeatOptions();

        Assert.assertEquals(actualOptions,expectedOptions);
    }
}


