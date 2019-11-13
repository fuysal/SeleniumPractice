package com.cybertek.Day12_waits;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    String loadingLocator = "#loading";
    String removeLocator = "//button[text()='Remove'] ";
    String enableLocator  = "#input-example>[type='button']";
    String addLocator = "//button[text()='Add']";


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
        System.out.println(driver.findElement(By.cssSelector(loadingLocator)).getText() );


        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //wait until input box is visible
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(usernameLocator))));
        driver.findElement(By.cssSelector(usernameLocator)).sendKeys("tomsmith ");
        driver.findElement(By.cssSelector(passwordLocator)).sendKeys("SuperSecretPassword ");

        driver.findElement(By.cssSelector(submitLocator)).click();


    }

    @Test
    public void waitForElementToBeClickable(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.xpath(removeLocator)).click();
        //SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(addLocator)).click();
    }
    @Test
    public void waitForElementToBeClickable2() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.xpath(removeLocator)).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(addLocator))));
        //SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(addLocator)).click();
    }
        @Test
        public void waitForElementToBeClickable3(){
            driver.get("http://practice.cybertekschool.com/dynamic_loading/5");

            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(  driver.findElement(By.cssSelector(submitLocator))));
            driver.findElement(By.cssSelector(submitLocator)).click();


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
