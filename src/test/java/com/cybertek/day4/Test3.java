package com.cybertek.day4;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
    public static void main(String[] args) throws Exception{
        //this line replaces System.setProperty("driver", "path")
        WebDriverManager.chromedriver().setup();//setup webdriver
        WebDriver driver =  new ChromeDriver() ;// create driver object
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");// open the url

        WebElement inputBox = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.id("form_submit")); // find element

        inputBox.sendKeys("abcd@gmail.com");
        System.out.println(inputBox.getAttribute("pattern"));
        System.out.println(inputBox.getAttribute("value"));
        submitButton.submit(); // works with only buttons






        Thread.sleep(2000);



        driver.close();
    }
}
