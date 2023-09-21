package com.utku_isbir;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataRead {

    private static final String FILE_PATH = "./utku.xlsx";
    public static List<String> excelList = new ArrayList<String>();

    public static List<String> readData(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(new File(FILE_PATH));

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(0);

        Cell cell1 = row.getCell(0);

        Cell cell2 = row.getCell(1);
                
        System.out.println("First cell value: " + cell1);
        System.out.println("Second cell value: " + cell2);

        excelList.add(cell1.toString());
        excelList.add(cell2.toString());

        workbook.close();
        file.close();

        return excelList;



 
    }
}
