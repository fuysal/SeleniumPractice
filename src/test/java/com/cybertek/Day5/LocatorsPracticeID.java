package com.cybertek.Day5;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPracticeID {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception{
        //test1();
        //test2();
        test3();
    }
        public static void test1() throws Exception{
        driver.manage().window().maximize();
        //selenium will wait for 10 sec if it doesn't show up selenium will display NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        WebElement loginButton = driver.findElement(By.id("woodenspoon"));
        Thread.sleep(2000);

        driver.close();

    }
    public static void test2() throws Exception{
        driver.manage().window().maximize();
        //you must use it otherwise it will give you a lot of problems
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);

        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = driver.findElement(By.className("subheader")).getText();

        SeleniumUtils.verifyEquals(expectedMessage,actualMessage);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("flash")).getAttribute("value"));

        driver.close();

    }

    public static void  test3(){
    driver.manage().window().maximize();
    driver.get("http://practice.cybertekschool.com/login");
    driver.findElement(By.name("username")).sendKeys("tomsmith");
    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
    driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER );
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

    String actualMessage = driver.findElement(By.className("subheader")).getText();
    String expextedMessage = "Welcome to the Secure Area. When you are done click logout below.";

    SeleniumUtils.verifyEquals(expextedMessage,actualMessage);
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
    driver.findElement(By.linkText("Logout")).click();

    driver.close();





    }








}
