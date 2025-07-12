package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {
    public static Iterator<User> readCSV(String fileName)  {
         File csvFile = new File(System.getProperty("user.dir") + "\\testdata\\" + fileName);
        FileReader fileReader = null;
        CSVReader csvReader;
        String [] line;
        List<User> userList = new ArrayList<>();
        User userData = null;


        try {
            fileReader = new FileReader(csvFile);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext(); // skip header
            while ((line = csvReader.readNext()) != null) {
                userData = new User(line[0], line[1]);
                userList.add(userData);
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }
        return userList.iterator();

    }
}
