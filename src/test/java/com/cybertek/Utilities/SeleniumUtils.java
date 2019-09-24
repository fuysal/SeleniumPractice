package com.cybertek.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumUtils {
    /**
     *         VERIFIES IF TO STRINGS ARE EQUALS
     * */
    public static void verifyEquals(String expectedResult, String actualResult){
        if (expectedResult.equals(actualResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected result: "+ expectedResult);
            System.out.println("Actual result: "+ actualResult);
        }
    }

    /**
     * This method will put on pause execution
     * @param seconds
     */

    public static void waitPlease(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param page
     * @param driver
     * This method will open example page based on link name
     */

    public static void openPage (String page, WebDriver driver){
        List<WebElement> listOfPages = driver.findElements(By.tagName("a"));
        for(WebElement example : listOfPages){
            example.click();
            break;
        }
    }
}
