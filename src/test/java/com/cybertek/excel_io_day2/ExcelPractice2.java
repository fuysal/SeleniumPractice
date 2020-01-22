package com.cybertek.excel_io_day2;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelPractice2 {

    Workbook workbook;
    Sheet sheet;
    String path = "src\\test\\resources\\Counties.xlsx";
    FileInputStream inputStream;
    FileOutputStream outputStream;


    @BeforeMethod
    public void setUp() throws IOException {
        inputStream = new FileInputStream(path);
        workbook = WorkbookFactory.create(inputStream);
        outputStream = new FileOutputStream(path);

        //Workbook wb3 = WorkbookFactory.create(inputStream);'
        sheet = workbook.getSheet("Countries");

    }

    @Test
    public void putDataIntoListOfMapTest2() {
        List<Map<String, String>> table = new ArrayList<>();
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        for (int row = 1; row <= rowCount; row++) {
            Map<String, String> map = new HashMap<>();
            for (int column = 0; column < colCount; column++) {
                String columnName = sheet.getRow(0).getCell(column).getStringCellValue();
                String columnValue = sheet.getRow(row).getCell(column).getStringCellValue();
                map.put(columnName, columnValue);

            }

            table.add(map);

        }
       // System.out.println(table);
        for(Map<String,String> values :table){
            System.out.println(values);
        }
    }

    @Test
    public void writeDataInExcelFIleTest(){
        Cell columnName = sheet.getRow(0).getCell(2);
        if(columnName==null){
            //to create a cell ? we need to create a cell before writing into it
            columnName = sheet.getRow(0).createCell(2);
        }
        //to write something into cell
        columnName.setCellValue("Result");
        int rowCount = sheet.getLastRowNum();
        for (int row = 1; row < rowCount; row++) {
            Row rowNumber = sheet.getRow(row);
            Cell cell = rowNumber.getCell(2);

            if(cell==null){
                cell = rowNumber.createCell(2);
            }

            cell.setCellValue("Pass");
        }

    }

    @AfterMethod
    public void tearDown() throws IOException {
        workbook.write(outputStream);
        workbook.close();
        inputStream.close();
    }
}
