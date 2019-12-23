package com.cybertek.Day13_actions_jsexecutor;

import com.cybertek.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionClassTests {
    WebDriver driver;
    String user1Locator = "//h5[text()='name: user1']";
    //String user1Locator = "//a[@href='/users/1']/preceding-sibling::h5";
    String imagesLocator = "img";
    String namesLocator = "h5";
    String enabledLocator = "#ui-id-3";
    String downloadLocator = "#ui-id-4";
    String pdfLocator ="#ui-id-5";
    String earthLocator = "droptarget";
    String moonLocator ="draggable";


    String firstImageLocator = "(//img)[1]";
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }
    @Test
    public void hoverTest1(){
        driver.get("http://practice.cybertekschool.com/hovers");
        //we create object of Actions class
        //we have to provide object of webdriver

        Actions action  =  new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(firstImageLocator))).perform();
        Assert.assertTrue(driver.findElement(By.xpath(user1Locator)).isDisplayed());
        String  actualText = driver.findElement(By.xpath(user1Locator)).getText();
        String expectedText = "name: user1";
        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void hoverTest2() {
        driver.get("http://practice.cybertekschool.com/hovers");
        //we create object of Actions class
        //we have to provide object of webdriver
        Actions action = new Actions(driver);
        List<WebElement> images = driver.findElements(By.tagName(imagesLocator));
        for (WebElement image : images) {
            action.moveToElement(image).perform();
            SeleniumUtils.waitPlease(1);
            // System.out.println(driver.findElement(By.tagName(namesLocator)).getText());

        }
    }
    @Test
            public void hoverTest3(){
            driver.get("http://practice.cybertekschool.com/jqueryui/menu");
            Actions action = new Actions (driver);
            action.moveToElement(driver.findElement(By.cssSelector(enabledLocator))).perform();
            SeleniumUtils.waitPlease(1);
            action.moveToElement(driver.findElement(By.cssSelector(downloadLocator))).perform();
            SeleniumUtils.waitPlease(1);
            action.moveToElement(driver.findElement(By.cssSelector(pdfLocator))).perform();

            WebElement enabledElement = driver.findElement(By.cssSelector(enabledLocator));
            WebElement downloadsElement = driver.findElement(By.cssSelector(downloadLocator));
            WebElement pdfElement = driver.findElement(By.cssSelector(pdfLocator));

    }
    @Test
    public void hoverTest4(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Actions action = new Actions (driver);

        WebElement enabledElement = driver.findElement(By.cssSelector(enabledLocator));
        WebElement downloadsElement = driver.findElement(By.cssSelector(downloadLocator));
        WebElement pdfElement = driver.findElement(By.cssSelector(pdfLocator));
        action.moveToElement(enabledElement).
                pause(1000).moveToElement(downloadsElement).
                pause(1000).moveToElement(pdfElement).click().build().perform();

        SeleniumUtils.waitPlease(4);

    }
    @Test
    public void dragDropTest(){

    driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
    Actions action = new Actions(driver);
    WebElement moon = driver.findElement(By.id(moonLocator))    ;
    WebElement earth = driver.findElement(By.id(earthLocator));

    action.dragAndDrop(moon,earth).perform();
    String expectedMessage = "You did great!";
    String actualMessage = earth.getText();
    Assert.assertEquals(actualMessage,expectedMessage);

        SeleniumUtils.waitPlease(3);





    }

    @AfterMethod

    public void tearDown(){
        driver.quit();
    }
}
