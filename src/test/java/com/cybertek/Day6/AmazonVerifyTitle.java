package com.cybertek.Day6;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AmazonVerifyTitle {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) {
        //verifyTitle();
        Wiki();

    }
    public static void verifyTitle(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("coding", Keys.ENTER);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com: coding";

       // SeleniumUtils.verifyEquals(actualTitle,expectedTitle);
        if(actualTitle.contains("coding")){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        driver.close();

    }
    public static void Wiki (){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.name("search")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Selenium")).click();

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        String url = driver.getCurrentUrl();
        if(url.endsWith("x")){
            System.out.println("passed");

        }else{
            System.out.println("failed");
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.close();



    }
}
