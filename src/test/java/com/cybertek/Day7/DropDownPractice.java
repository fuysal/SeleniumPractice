package com.cybertek.Day7;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropDownPractice {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openDropDownPage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test1();
        driver.close();
        



    }

    public static void openDropDownPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement element = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
        SeleniumUtils.verifyIsDisplayed(element);
    }
    public static void test1(){
        WebElement   dropdown1 = driver.findElement(By.id("dropdown"));
        // to work with selected elements we need to use Select class
        Select dropdownSelect = new Select(dropdown1);
        String selected = dropdownSelect.getFirstSelectedOption().getText();
        System.out.println(selected);


    }
}
