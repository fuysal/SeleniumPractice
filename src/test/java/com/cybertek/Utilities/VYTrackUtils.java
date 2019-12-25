package com.cybertek.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.Utilities;

public class VYTrackUtils {
   private static String usernameLocator = "prependedInput";
    private static String passwordLocator = "prependedInput2";
    private static String screenLoaderMaskLocator = "div[class='loader-mask shown']";


    /**
     * Login ino vytrack app
     * @param driver
     * @param username
     * @param password
     */


    public static void login(WebDriver driver, String username, String password) {
        driver.findElement(By.id(usernameLocator)).sendKeys(username);

        driver.findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
        SeleniumUtils.waitPlease(3);

    }

    /**
     * this method will navigate user to the specific module in vytrack application.
     * @param driver
     * @param tab
     * @param module
     */
    public static void navigateToModules(WebDriver driver, String tab, String module){
        String tabLocator = "//span[contains(text(),'"+tab+"')and contains(@class,'title title-level-1')]";
        String moduleLocator = "//span[contains(text(),'"+module+"')and contains(@class,'title title-level-2')]";
       // driver.findElement(By.xpath(tabLocator)).click();
        SeleniumUtils.clickWithWait(driver, By.xpath(tabLocator),5);
        SeleniumUtils.waitPlease(1);

       // driver.findElement(By.xpath(moduleLocator)).click();
        SeleniumUtils.clickWithWait(driver,By.xpath(moduleLocator),5);
        SeleniumUtils.waitPlease(1);
    }

    /**
     *waits until loader screen present. If loader screen will not get away at all.
     * NoSuchElementException will be handled by try/catch block
     * Thus, we can continue any case.
     * @param driver
     */
    public static void waitUntilLoaderScreenDisappear(WebDriver driver){
       try {
           WebDriverWait wait =  new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(screenLoaderMaskLocator))));
       }catch (Exception e){
           System.out.println(e + "Loader mask doesn't disappear");
       }
    }

}
