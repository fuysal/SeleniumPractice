package com.cybertek.Day5;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetNumOfElementsOnPage {
    public static void main(String[] args) throws Exception {
        getListOfElements();
    }
    public static void getListOfElements() throws Exception{
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");

        List<WebElement> elements = driver.findElements(By.className("list-group-item"));
        int count = 0;
        for (WebElement element : elements){
            Thread.sleep(1000);
            System.out.println(element.getText());
            count++;
        }
        System.out.println(count);
        int expectedResult = 48;
        int actualResult = count;

        if (expectedResult == actualResult){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected result: "+ expectedResult);
            System.out.println("Actual result: "+ actualResult);
        }

        driver.close();
    }
}
