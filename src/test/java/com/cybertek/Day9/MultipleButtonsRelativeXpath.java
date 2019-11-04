package com.cybertek.Day9;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MultipleButtonsRelativeXpath {
    WebDriver driver;
    String button1Locator = "//button[.='Button 1'] ";
    String button2Locator = "//*[contains(@name,'button2')]  ";
    String button3Locator = "//button[starts-with(@id,'button_')]";
    String button4Locator = "//button[contains(text(),'Button 4')]";
    String button5Locator = "//button[5] ";
    String butotn6Locator = "//*[@id='disappearing_button'] ";
    String buttons = "//button[starts-with(text(),'Button')]";
    String result = "//p[@id='result'] ";

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

    }

    @Test
    public void verifyButton3(){
        driver.findElement(By.xpath(button3Locator)).click();
        String actualMessage = driver.findElement(By.xpath(result)).getText();
        String expectedMessage = "Clicked on button three!";
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void verifyButton4(){
        driver.findElement(By.xpath(button4Locator)).click();
        String actualMessage = driver.findElement(By.xpath(result)).getText();
        String expectedMessage = "Clicked on button four!";
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void verifyButton6IsDisplayed(){
        String expectedMessage = "Now it's gone!";
        driver.findElement(By.xpath(butotn6Locator)).click();
        String actualMessage = driver.findElement(By.xpath(result)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
       // Assert.assertTrue(driver.findElement(By.xpath(butotn6Locator)).isDisplayed());> will fail
        // because the element is not in the DOM/HTML
        // .size ==0 is the right way to check if a elements is displayed
        // looking how many elements with that locator on the page
        Assert.assertTrue(driver.findElements(By.xpath(butotn6Locator)).size()==0);



    }
    @Test
    public void findAllButtons(){
        List<WebElement> allButtons = driver.findElements(By.xpath(buttons));
        for ( WebElement eachButton:allButtons){
            eachButton.click();
            SeleniumUtils.waitPlease(2);
        }

    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
