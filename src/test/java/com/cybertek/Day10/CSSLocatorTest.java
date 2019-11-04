package com.cybertek.Day10;

import com.cybertek.Utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

public class CSSLocatorTest {
    String button1Locator = "[onclick='button1()']";
    String button2Locator = ".btn:nth-of-type(2)";
    String button3Locator = "[id^='button_']"; // ^ means start with
    String button4Locator = "[id$='_button'][onclick='button4()']"; //$ means ends with
    String Button5Locator  = "[onclick*='5']"; // * means contains
    String Button6Locator  = "#disappearing_button"; // # id
    String resultLocator = "#result";

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();

    }
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");



    }

   // @Ignore
    @Test (priority = 1, description = "verifying button 1",dependsOnMethods ={"verifyButton2"})//this means it depends on verifyButton2 method, if it fails no need to run this test.
    // it may be more than 1 dependencies
    public void verifyButton1(){

        driver.findElement(By.cssSelector(button1Locator)).click();
        String expectedMessage = "Clicked on button one!";
        String actualMessage = driver.findElement(By.cssSelector(resultLocator)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test (priority = 2, description = "verifying button 2" )
    public void verifyButton2(){

        driver.findElement(By.cssSelector(button2Locator)).click();
        String expectedMessage = "Clicked on button two!";
        String actualMessage = driver.findElement(By.cssSelector(resultLocator)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
        throw new SkipException("I want to skip this test");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
