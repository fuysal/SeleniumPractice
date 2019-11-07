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

import java.util.concurrent.TimeUnit;

public class SaveAndCancelOptionsTest {
    WebDriver driver;
    String createCalendarEventButtonLocator = "a[title='Create Calendar event']";
    String cancelButtonLocator = "[title='Cancel']";
    String saveAndCloseButtonLocator = "//div/button[contains(text(),'Save and Close')]";
    String toggleLocator = "a[class='btn-success btn dropdown-toggle']";
    String getSaveAndCloseButtonDropdownLocator = "[class='action-button dropdown-item']";
    String saveAndNewLocator = "//li/button[contains(text(),'Save and New')]";
    String saveLocator = "(//li/button[contains(text(),'Save')])[3]";
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        VYTrackUtils.login(driver, "salesmanager253", "UserUser123");

    }
    @Test
    public void verifyCancelButton(){
        VYTrackUtils.navigateToModules(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(cancelButtonLocator)).isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
