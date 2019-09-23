package com.cybertek.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTest2 {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        Thread.sleep(2000);
        WebElement inputBox = driver.findElement(By.name("email"));
        inputBox.sendKeys("test123@gmail.com");
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.id("form_submit"));
        submitButton.click();
        Thread.sleep(5000);
        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirmationMessage.getText();

        if(actualMessage.equals(expectedMessage)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        driver.close();
    }
}
