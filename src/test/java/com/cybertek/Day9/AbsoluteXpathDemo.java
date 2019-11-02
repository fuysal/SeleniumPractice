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
    private WebDriver driver = BrowserFactory.getDriver("chrome");
    @BeforeMethod
    public void setUp(){
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

    }

    @Test
    public void test1(){
        WebElement fullName = driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div[1]/div/input"));
        fullName.sendKeys("alp mammadov");

        WebElement email = driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div[2]/div/input"));
        email.sendKeys("alp@gmail.com");
        SeleniumUtils.waitPlease(2);

        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        SeleniumUtils.waitPlease(5);

        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = driver.findElement(By.name("signup_message")).getText();
        SeleniumUtils.waitPlease(2);

        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @AfterMethod
    public void tearDown(){
        SeleniumUtils.waitPlease(2);
        driver.quit();
    }
}
