package com.cybertek.Day13_actions_jsexecutor;

import com.cybertek.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.io.SessionOutputBuffer;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecuterTests {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void jsExecutorTest1(){
        driver.get("http://practice.cybertekschool.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String title =  (String) js.executeScript("return document.title");
        js.executeScript("alert('Privet!')");
        Alert alert = driver.switchTo().alert();
        SeleniumUtils.waitPlease(3);
        alert.accept();
        System.out.println(title);


    }
    @Test
    public void scrollTest1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        for (int i=0; i<11; i++) {
            js.executeScript("window.scrollBy(0,500)");
            SeleniumUtils.waitPlease(1);
        }
    }
    @Test
    public void scrollTest2(){
        driver.get("http://practice.cybertekschool.com");
        WebElement footLink = driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        SeleniumUtils.waitPlease(2);
        js.executeScript("arguments[0].scrollIntoView(true)", footLink);
        SeleniumUtils.waitPlease(2);
        js.executeScript("arguments[0].click()", footLink);

    }

    @AfterMethod
    public void teardown(){
        SeleniumUtils.waitPlease(3);
        driver.quit();
    }
}
