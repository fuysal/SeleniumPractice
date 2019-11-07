package com.cybertek.Day11_vytrack;

import com.cybertek.Utilities.SeleniumUtils;
import com.cybertek.Utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.print.MultiDocPrintService;
import java.util.concurrent.TimeUnit;

public class CreateButtonIsDisplayed {

    WebDriver driver;
    String logCallLocator = "a[title='Log call']";
    String createCalendarEventButtonLocator = "a[title='Create Calendar event']";


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test (priority = 1)
    public void storeManagerLogCallButtonIsDisplayed(){
        VYTrackUtils.login(driver, "storemanager85", "UserUser123");
        //login
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //navigate to calls
        VYTrackUtils.navigateToModules(driver, "Activities", "Calls");
        SeleniumUtils.waitPlease(3);
        Assert.assertTrue(driver.findElement(By.cssSelector(logCallLocator)).isDisplayed());
        SeleniumUtils.waitPlease(3);
      // Assert.assertTrue(driver.findElements(By.cssSelector(logCallLocator)).size()==0);


    }
    @Test
    public void storeManagerCreateClandarEventButtonIsDisplayed(){
        VYTrackUtils.login(driver, "storemanager85", "UserUser123");
        //login
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //navigate to calendar activities
        VYTrackUtils.navigateToModules(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(10);
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).isDisplayed());
        SeleniumUtils.waitPlease(3);
        // Assert.assertTrue(driver.findElements(By.cssSelector(logCallLocator)).size()==0);


    }

    @Test
    public void salesManagerTest(){
        VYTrackUtils.login(driver, "salesmanager253", "UserUser123");
        //login
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //navigate to calls
        VYTrackUtils.navigateToModules(driver, "Activities", "Calls");
      //  SeleniumUtils.waitPlease(13);
        Assert.assertTrue(driver.findElement(By.cssSelector(logCallLocator)).isDisplayed());
      //  SeleniumUtils.waitPlease(13);

        //navigate to calendar activities
        VYTrackUtils.navigateToModules(driver, "Activities", "Calendar Events");
        //SeleniumUtils.waitPlease(10);
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).isDisplayed());
        SeleniumUtils.waitPlease(3);


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
