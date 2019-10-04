package com.cybertek.SortPractices;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CSSLocator {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Yar");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Mammadov");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("smammadov");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("smammadov@gmail.com");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.cssSelector("input[type='radio']")).click();
        SeleniumUtils.waitPlease(2);
        Select dropDownSelect = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("QA");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.id("inlineCheckbox2")).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.id("wooden_spoon")).click();
        SeleniumUtils.waitPlease(3);
        driver.close();
    }
}
