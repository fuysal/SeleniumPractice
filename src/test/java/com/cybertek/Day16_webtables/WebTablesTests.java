package com.cybertek.Day16_webtables;

import com.cybertek.Utilities.SeleniumUtils;
import com.cybertek.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTablesTests extends TestBase {
    @Test
    public void tableTest1(){
        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());
    }
    @Test
    public void tableTest2(){
        WebElement thead = driver.findElement(By.id("table1")).findElement(By.tagName("thead"));
        System.out.println(thead.getText());
    }

    @Test
    //Find number of rows in a table
    public void numberOfRows(){

        String rowsLocator = "[id='table1']>tbody tr";
        List<WebElement> rows = driver.findElements(By.cssSelector(rowsLocator));
        System.out.println("Number of rows: "+rows.size());



    }
    @Test
    //Find number all rows in the table 2
    public void numberAllOfRowsInTable2(){

        String rowsLocator = "#table2 tr";
        List<WebElement> rows = driver.findElements(By.cssSelector(rowsLocator));
        Assert.assertEquals(rows.size(),5);
        System.out.println("Number of all rows in the table 2: "+rows.size());
    }
    @Test
    //Print all column names from table1 and list them out
    public void printAllColumnNames(){

        String columnsLocator = "#table1 th";
        List<WebElement> columns = driver.findElements(By.cssSelector(columnsLocator));
        for (WebElement column:columns){
            System.out.println(column.getText());
        }
    }
    @Test
    public void printCertainRow(){
        int rowNumber = 3;
        //table:nth-of-type(1)>tr:nth-of-type(3) with css
        String row = "//table[1]/tbody/tr["+rowNumber+"]";
        WebElement rowElement = driver.findElement(By.xpath(row));
        System.out.println(rowElement.getText());

    }

    @Test
    public void test3(){
        SeleniumUtils.getTableData(driver,1,3,3);
    }
    @Test
    public void printSpecificColumnDataTest(){
        System.out.println(getColumnData("Due"));
    }

    @Test
    public void verifyNameIsDisplayed(){
        String firstName = "Jason";
        String lastName = "Doe";

        String firstNameLocator = "//table[1]//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tr[3]//td[1]";

        String actualName = driver.findElement(By.xpath(firstNameLocator)).getText();
        String  actualLastName = driver.findElement(By.xpath(lastNameLocator)).getText();

        Assert.assertEquals(actualLastName, lastName);
        Assert.assertEquals(actualName, firstName);


    }

    public void verifyRecordHasBeenDeleted(){
        String firstName = "Jason";
        String lastName = "Doe";

        String firstNameLocator = "//table[1]//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tr[3]//td[1]";
        String target = "//table[1]//td[text()='"+firstName+"']";
        String deleteLocator = "//table[1]//td[text()='"+firstName+"']/following-sibling::td//a[text()='delete']";
        driver.findElement(By.xpath(deleteLocator)).click();
  //      Assert.assertTrue(driver.findElement(By.xpath(target)).isEmpty());

    }


    public List<String> getColumnData( String columnName){
        List<String > values = new ArrayList<>();
        List<WebElement> headings = driver.findElements(By.xpath("//table[1]//th"));

        int columnNumber =0;
        for (int i = 0; i < headings.size(); i++) {
            if(headings.get(i).getText().equals(columnName)){
                columnNumber = i+1;
                break;
            }

        }
        List<WebElement> columnList = driver.findElements(By.xpath("//table[1]//tr//td["+columnNumber+"]"));
        for(WebElement columnValue : columnList){
            values.add(columnValue.getText());
        }
        return values;

    }
}
