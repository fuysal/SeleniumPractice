package com.cybertek.day4;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
    public static void main(String[] args) throws Exception{
        //this line replaces System.setProperty("driver", "path")
        WebDriverManager.chromedriver().setup();//setup webdriver
        WebDriver driver =  new ChromeDriver() ;// create driver object
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");// open the url
        WebElement inputBox = driver.findElement(By.name("email"));

        Faker faker = new Faker();

        String email = faker.name().replace(" ","").toLowerCase();
        String email2 = faker.country().replace(" ","").toLowerCase();
        inputBox.sendKeys(email2+"@gmail.com");
        Thread.sleep(2000);
        inputBox.clear();


        inputBox.sendKeys(email+"@gmail.com"+ /*test*/ Keys.ENTER);// to enter text
        Thread.sleep(2000);
        //WebElement submitButton = driver.findElement(By.id("form_submit")); // find element
        //submitButton.click();
        Thread.sleep(2000);



        driver.close();
    }
}
