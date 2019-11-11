package com.cybertek.Day12_waits;

import com.cybertek.Utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class ExpilicitWaitTest {
    String startButtonLocator="#start>button";
    String usernameLocator = "#username";
    String passwordLocator = "#pwd";
    String submitLocator = "[type='submit']";


    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver = BrowserFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(  10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void waitForVisibilityTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.cssSelector(startButtonLocator)).click();
        driver.findElement(By.cssSelector(usernameLocator)).sendKeys("tomsmith ");
        driver.findElement(By.cssSelector(passwordLocator)).sendKeys("SuperSecretPassword ");
        driver.findElement(By.cssSelector(submitLocator)).click();


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
