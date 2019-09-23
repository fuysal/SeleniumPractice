package com.cybertek.Day5;

import com.cybertek.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeTagName{
    public static void main(String[] args) throws Exception {
        test1();

    }
    public static void test1 () throws Exception{
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //we use findElements for multiple elements we have to store them in a list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("Size"+buttons.size());// to get how many elements in the list
        for (WebElement button: buttons){
            System.out.println(button.getText());
            button.click();
            Thread.sleep(2000);
        }

        //StaleElementReferenceException means Selenium can't find that element any more. Since after clicking button-
        //- disappeared selenium won't able to find it again.
        driver.close();

    }
}
