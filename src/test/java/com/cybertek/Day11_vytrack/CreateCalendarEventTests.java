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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class CreateCalendarEventTests {
    WebDriver driver;
    String createCalendarEventButtonLocator = "a[title='Create Calendar event']";
    String cancelButtonLocator = "[title='Cancel']";
    String saveAndCloseButtonLocator = "//div/button[contains(text(),'Save and Close')]";
    String toggleLocator = "a[class='btn-success btn dropdown-toggle']";
    String saveAndCloseButtonDropdownLocator = "[class='action-button dropdown-item']";
    String saveAndNewLocator = "//li/button[contains(text(),'Save and New')]";
    String saveLocator = "(//li/button[contains(text(),'Save')])[3]";
    String defaultOwnerLocator = ".select2-chosen";
    String currentUserLocator = "//li/a[@class='dropdown-toggle']";
    String titleLocator = "[id^='oro_calendar_event_form_title-uid']";
    String startDateLocator = "[id^='date_selector_oro_calendar_event_form_start']";
    String startTimeLocator ="[id^='time_selector_oro_calendar_event_form_start-uid-5dc3a413d']";




    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        VYTrackUtils.login(driver, "salesmanager110", "UserUser123");

    }
    @Test
    public void verifyCancelButton(){
        VYTrackUtils.navigateToModules(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(cancelButtonLocator)).isDisplayed());

    }
    @Test
    public  void verifySaveAndCloseDropdown()  {
        VYTrackUtils.navigateToModules(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.waitPlease(5);
        Assert.assertTrue(driver.findElement(By.xpath(saveAndCloseButtonLocator)).isDisplayed());
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.cssSelector(toggleLocator)).click();
        SeleniumUtils.waitPlease(5);
        Assert.assertTrue(driver.findElement(By.cssSelector(saveAndCloseButtonDropdownLocator)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(saveAndNewLocator)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(saveLocator)).isDisplayed());


    }
    @Test
    public void verifyOwnersMatch(){
        VYTrackUtils.navigateToModules(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.waitPlease(5);
        String expectedOwner = driver.findElement(By.xpath(currentUserLocator)).getText().trim();
        String  actualOwner = driver.findElement(By.cssSelector(defaultOwnerLocator)).getText().trim();
        Assert.assertEquals(actualOwner,expectedOwner);
    }
    @Test
    public void verifyTitleIsEmpty(){
        VYTrackUtils.navigateToModules(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.waitPlease(5);
        //to check textbox is empty
        Assert.assertTrue(driver.findElement(By.cssSelector(titleLocator)).getText().length()==0);
        //or this way
       // Assert.assertTrue(driver.findElement(By.cssSelector(titleLocator)).getAttribute("value").length()==0);


    }
    @Test
    public void verifyDateMatchesCurrentDate(){
        VYTrackUtils.navigateToModules(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.waitPlease(5);
       // String expectedDate = "Nov 6, 2019";

        String actualDate = driver.findElement(By.cssSelector(startDateLocator)).getAttribute("value");
        SeleniumUtils.waitPlease(3);
        String actualTime = driver.findElement(By.cssSelector(startTimeLocator)).getAttribute("value");
        SeleniumUtils.waitPlease(3);
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM,d, yyy"));
        SeleniumUtils.waitPlease(3);
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a")) ;

        //inorder to get text from input box you should say getAttribute("value") NOT getText


        Assert.assertEquals(actualDate,currentDate);
        Assert.assertEquals(currentTime,actualTime);




    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
