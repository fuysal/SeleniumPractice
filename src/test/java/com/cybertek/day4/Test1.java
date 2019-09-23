package com.cybertek.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    public static void main(String[] args) throws Exception{
        //this line replaces System.setProperty("driver", "path")
        WebDriverManager.chromedriver().setup();//setup webdriver
        WebDriver driver =  new ChromeDriver() ;// create driver object
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");// open the url
        WebElement inputBox = driver.findElement(By.name("email"));
        inputBox.sendKeys("avd@gmail.com");// to enter text
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.id("form_submit")); // find element
        submitButton.click();
        Thread.sleep(2000);

        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirmationMessage.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected message: "+ expectedMessage);
            System.out.println("Actual message: "+ actualMessage);
        }


        driver.close();
    }
}
