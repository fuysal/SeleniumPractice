package com.cybertek.Day6;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonTests {
   static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openRadioButton();
        test4();
        // test3();
        //test2();
        //test1();


    }
    public static void  openRadioButton(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }
    public static void test1(){
        WebElement radioBtn = driver.findElement(By.id("blue"));
        if (radioBtn.isSelected()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        SeleniumUtils.waitPlease(2);
        driver.close();
    }
    public static void test2(){
        WebElement blackBtn = driver.findElement(By.id("black"));
        WebElement greenBtn = driver.findElement(By.id("green"));

        if(blackBtn.isEnabled() && (!greenBtn.isEnabled())){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        SeleniumUtils.waitPlease(5);
        driver.close();
    }
    public static void test3(){
        WebElement radioBtn = driver.findElement(By.id("blue"));
        if (radioBtn.isSelected()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        SeleniumUtils.waitPlease(5);
        WebElement blackBtn = driver.findElement(By.id("black"));
        blackBtn.click();
        if(blackBtn.isSelected() && (!radioBtn.isSelected())){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        SeleniumUtils.waitPlease(5);
        driver.close();
    }
    public static void test4(){
        List<WebElement> numOfRadioButtons = driver.findElements(By.xpath("//input[@type='radio']" ));
        int counter = 0;
        for(WebElement radioButton: numOfRadioButtons){
            if(radioButton.isSelected()){
                System.out.println(radioButton.getAttribute("id"));
                counter++;
            }

        }
        System.out.println("Number of selected radio buttons: "+ counter);

        driver.close();

    }
}
