package com.cybertek.Day6;

import com.cybertek.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxTest {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
    //test1();
    test2();


    }

    public static void  openCheckboxPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkboxLogo = driver.findElement(By.tagName("h3"));
        if(checkboxLogo.isDisplayed()){
            System.out.println("checkbox logo is visible");
        }else{
            System.out.println("logo is not visible! ");
        }
    }
    public static void test1(){
        openCheckboxPage();
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        if(!checkbox1.isSelected()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        if(checkbox2.isSelected()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        driver.close();

    }
    public static void test2(){
        openCheckboxPage();
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        checkbox1.click();
        checkbox2.click();
        if(checkbox1.isSelected()&&(!checkbox2.isSelected())){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.close();

    }
}
