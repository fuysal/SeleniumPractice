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

public class AbsoluteXpathDemo {
    //we use only in this class, that's why it is private.
    private WebDriver driver;
    String fullNameLocator = "html/body/div/div[2]/div/div/form/div[1]/div/input";
    String emailLocator = "html/body/div/div[2]/div/div/form/div[2]/div/input";
    String signUpLocator = "//*[@id=\"login\"]/button";
    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

    }

    @Test
    public void test1(){

        //find full name input box to put name
        WebElement fullName = driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div[1]/div/input"));
        fullName.sendKeys("alp mammadov");


        //find email input box to put email
        WebElement email = driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div[2]/div/input"));
        email.sendKeys("alp@gmail.com");

        //find signup button and click
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        SeleniumUtils.waitPlease(5);
        //verify expected and actual message is the same if not stop the test and throw an exception
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = driver.findElement(By.name("signup_message")).getText();
        SeleniumUtils.waitPlease(2);

        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void negativeEmailTest(){
        String expectedLink = driver.getCurrentUrl();
        driver.findElement(By.xpath(fullNameLocator)).sendKeys("yar");
        driver.findElement(By.xpath(emailLocator)).sendKeys("@tmail.ses");
        driver.findElement(By.xpath(signUpLocator)).click();
        String actualLink = driver.getCurrentUrl();
        SeleniumUtils.waitPlease(2);

        Assert.assertEquals(actualLink, expectedLink);


    }

    @AfterMethod
    public void tearDown(){
        SeleniumUtils.waitPlease(2);
        driver.quit();
    }
}
