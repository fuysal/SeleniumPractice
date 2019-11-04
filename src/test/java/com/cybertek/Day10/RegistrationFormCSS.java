package com.cybertek.Day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationFormCSS {
    WebDriver driver;
    String departmentLocator =  "[name='department']";
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/registration_form");

    }

    @Test
    public void departmentTest1(){
        Select select = new Select(driver.findElement(By.cssSelector(departmentLocator)));
        List <WebElement> allOptions = select.getOptions();
        for(WebElement eachOption:allOptions){
            System.out.println(eachOption.getText());
        }



    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
