package com.cybertek.Day5;

import com.cybertek.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AmazonTask {
    public static void main(String[] args) throws Exception {
        amazonSearch();

    }

    public static void amazonSearch() throws Exception{
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java");
        Thread.sleep(2000);
        driver.findElement(By.className("nav-input")).click();
        //or we can click right after typing in words
        // driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
        Thread.sleep(3000);
        //WebElement sResult = driver.findElement(By.tagName("span"));
        String sResult = driver.findElement(By.xpath("//*[@id=\"search\"]/span/h1/div/div[1]/div/div/span[1]")).getText();
        System.out.println(sResult);


        driver.close();
    }
}
