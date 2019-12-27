package com.cybertek.Day17_webtables2;

import com.cybertek.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.sql.Array;
import java.sql.ClientInfoStatus;
import java.util.*;

public class WebTablesTests extends TestBase {

    //get # of rows from a table
    public int getCountOfRows(){

        return driver.findElements(By.cssSelector("#table1 tr")).size();

    }

    //in this case we can use any type of locators Overload, same name different params
    public int getCountOfRows(By by){
        return driver.findElements(by).size();
    }

    //get # of columns from a table
    public int getCountOfColumns(){
        return driver.findElements(By.xpath("//table[1]//th")).size();
    }
    //get # of columns from a table
    public int getCountOfColumns(By by){
        return driver.findElements(by).size();
    }

    //get table size (rows and columns)
    public int [] getTableSize(){
        int [] size = {getCountOfRows(),getCountOfColumns()};
        return size;
    }

    //get table size (rows and columns) By by
    public int [] getTableSize(By rowsLocator, By columnLocator) {
        int [] size = {getCountOfRows(rowsLocator),getCountOfColumns(columnLocator)};
        return size;
    }

    //list all table headers

    /**
     *   public void getAllHeaders() {
     *         List<WebElement> headers = driver.findElements(By.cssSelector("#table1 th"));
     *
     *         for (WebElement head : headers) {
     *             System.out.println(head.getText());
     *         }
     *     }
     */

    //gets table headers as a list element
    public List<WebElement> getAllHeaders(){
        return driver.findElements(By.cssSelector("#table1 th"));
    }

    // gets headers as text as a list of text
    public List<String> getAllHeaderText(){
        List<String> headers = new ArrayList<>();
        for (WebElement tableHeader:getAllHeaders()){
            headers.add(tableHeader.getText())  ;
        }
        return headers;
    }

    // gets column data by column name
    public List<String> getColumnData(String columnName) {
        int columnNumber = 0;
        for (int i = 0; i < getCountOfColumns(); i++) {
            if (columnName.equals(getAllHeaderText().get(i))) {
                columnNumber = i + 1;
            }
        }
        String columnLocator = "//table[1]//tr/td[" + columnNumber + "]";
        List<WebElement> collectionOfDataElements = driver.findElements(By.xpath(columnLocator));

        List<String> collectionOfDataText = new ArrayList<>();
        for (WebElement element : collectionOfDataElements) {
            collectionOfDataText.add(element.getText());
        }
        return collectionOfDataText;

    }

    @Test
    public void testNumberOfRows(){
        Assert.assertEquals(getCountOfRows(),4,"Number of rows don't match ");
    }


    @Test
    public void testNumberOfRowsBY()
    {
        Assert.assertEquals(getCountOfRows(By.xpath("//table[1]//tr")),5,"Number of rows don't match ");
    }


    @Test
    public void testNumberOfColumns()
    {
        Assert.assertEquals(getCountOfColumns(),6,"Number of columns don't match ");
    }

    @Test
    public void testTableSize(){
        int [] expectedSize = {5,6};
        int [] actualSize = getTableSize();
        Assert.assertEquals(expectedSize,actualSize);
    }

    @Test
    public void testTableHeaders(){
       getAllHeaders();

    }
    @Test
    public void tableHeadersTest(){
        List<String > expectedNames = Arrays.asList("Last Name ","First Name","Email","Due","Web Site","Action");
        Assert.assertEquals(getAllHeaderText(),expectedNames, "Column names don't match");
    }

    @Test
    public void verifyColumnDataIsSortedTest(){
        String columnName = "First Name";
        driver.findElement(By.xpath("//table[1]//th//span[text()='"+columnName+"']"  )).click();
        System.out.println(getColumnData("First Name"));
        //create a list to compare
        List<String> sorted = new ArrayList<>();
        //add everything to the list
        sorted.addAll(getColumnData(columnName));
        //sort it with Collection sort
        Collections.sort(sorted);
        //compare if sorted list is the same as the before sorting
        Assert.assertEquals(getColumnData(columnName),sorted);
    }
    }


