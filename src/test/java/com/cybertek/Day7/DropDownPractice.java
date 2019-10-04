package com.cybertek.Day7;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractice {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openDropDownPage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test6();
        //test1();
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


        //we can see the list option using the below method
        List<WebElement> options = dropdownSelect.getOptions();
        for (WebElement eachOption :options)    {
            System.out.println(eachOption.getText());
        }

    }
    public static void test2(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select selectDropDown = new Select(dropdownState);
        List<WebElement> states = selectDropDown.getOptions();
        for (WebElement eachState:states){
            System.out.println(eachState.getText());
        }
        selectDropDown.selectByVisibleText("Florida");
        SeleniumUtils.waitPlease(3);
    }

    public static void test3(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select selectDropDown = new Select(dropdownState);
        List<WebElement> states = selectDropDown.getOptions();
        for (WebElement eachState:states){
            SeleniumUtils.waitPlease(1);
            //means find text and selcet it
            selectDropDown.selectByVisibleText(eachState.getText());
        }


    }
    //select by value
    public static void test4() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select selectDropDown = new Select(dropdownState);
        //means find value PA and select it
        selectDropDown.selectByValue("PA");
        SeleniumUtils.waitPlease(2);
        // to read which option is selected
        String actual = selectDropDown.getFirstSelectedOption().getText();
        String expected = "Pennsylvania";
        SeleniumUtils.verifyEquals(actual,expected);

    }
    //select by index
    public static void test5() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select selectDropDown = new Select(dropdownState);
        selectDropDown.selectByIndex(5);
        SeleniumUtils.waitPlease(2);
        // multi select

}
    public  static void test6(){
    WebElement multiSelect = driver.findElement(By.xpath("//select[@name='Languages']"));
    Select selectDropDown = new Select(multiSelect);
    selectDropDown.selectByVisibleText("Java");
    SeleniumUtils.waitPlease(2);
        selectDropDown.selectByVisibleText("JavaScript");
        SeleniumUtils.waitPlease(2);

    }

}
