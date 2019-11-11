package com.cybertek.Day12_waits;

import com.cybertek.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleepAndImpilicitWaitTests {
    String startButtonLocator="#start>button";
    String  helloWorldLocator = "#finish>h4";
    WebDriver driver;
    @BeforeMethod
    public void setup(){

        driver = BrowserFactory.getDriver("chrome");
        //can handle NoSuchElementException, within given time frame
        driver.manage().timeouts().implicitlyWait(  10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

    }

    @Test
    public void waitTest1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.findElement(By.cssSelector(startButtonLocator)).click();
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String expectedMessage = "Hello World!";
        String  actualMessage = driver.findElement(By.cssSelector(helloWorldLocator)).getText();

        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void waitTest2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        String expectedMessage = "Hello World!";
        String  actualMessage = driver.findElement(By.cssSelector(helloWorldLocator)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
