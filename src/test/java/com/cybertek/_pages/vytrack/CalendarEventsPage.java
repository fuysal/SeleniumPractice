package com.cybertek._pages.vytrack;

import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CalendarEventsPage {
    private WebDriver driver = Driver.getDriver();
   public String createCalendarEventsLocator = "[class='btn main-group btn-primary pull-right ']";
   public String repeatCheckBoxLocator = "[id^='recurrence-repeat-view']";
   public String repeatsDropDownLocator ="[id^='recurrence-repeats-view']";

    // let's write a method that return collection  of repeat options
    public List<String> getRepeatOptions(){
        // we created select object to work with dropdown
        Select select = new Select(driver.findElement(By.cssSelector(repeatsDropDownLocator)));
        //.getOption(); return all available options in the dropdown
        // every option is a webelemnt
        List<WebElement> options = select.getOptions();
        //this is  a collection that will contain text of every webelement
        List<String> optionTextList = new ArrayList<>();
        for (WebElement option:options) {
            //go throw every option and retrieve text
            //add that text into collection of text option
            optionTextList.add(option.getText());
        }
        return optionTextList;

    }

}
