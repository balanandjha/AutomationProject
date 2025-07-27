package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readExcelFile(String filename){

        File excelFile = new File(System.getProperty("user.dir") + "//testdata//" + filename);
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;
        Row row;
        Iterator<Row> rowIterator;
        Cell emailAddressCell;
        Cell passwordCell;
        User user;
        List<User> userList = new ArrayList<>();

        try {
            workbook = new XSSFWorkbook(excelFile);
            sheet = workbook.getSheet("LoginTestData");
            rowIterator = sheet.iterator();
            rowIterator.next();// Skip header row

            while (rowIterator.hasNext()){
                row = rowIterator.next();
                emailAddressCell = row.getCell(0);
                passwordCell = row.getCell(1);
                user = new User(emailAddressCell.toString(), passwordCell.toString());
                userList.add(user);
                workbook.close();
            }

        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
