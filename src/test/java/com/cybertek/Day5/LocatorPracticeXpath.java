package com.cybertek.Day5;

import com.cybertek.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class LocatorPracticeXpath {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) {
        testXpath();
    }
    public static void testXpath(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/input")).sendKeys("Javaluna");
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/input")).sendKeys("java@gmail.com");
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();



    }

}
