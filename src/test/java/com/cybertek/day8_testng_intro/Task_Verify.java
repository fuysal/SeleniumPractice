package com.cybertek.day8_testng_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_Verify {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        WebElement year = driver.findElement(By.id("year"));
        Select selectYear = new Select(year);

        int actualYear = Integer.parseInt(selectYear.getFirstSelectedOption().getText());
        int expectedYear = 2019;

        Select selectMonth = new Select(driver.findElement(By.id("month")));
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String expectedMonth = "November";

        Select selectDay = new Select((driver.findElement(By.id("day"))));
        int actualDay = Integer.parseInt(selectDay.getFirstSelectedOption().getText());
        int expectedDay = 1;

        Assert.assertEquals(actualYear,expectedYear);
        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualDay,expectedDay);

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
