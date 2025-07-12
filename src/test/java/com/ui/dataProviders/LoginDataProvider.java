package com.ui.dataProviders;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LoginDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir")+"\\testdata\\loginData.json");
        FileReader fileReader = new FileReader(testDataFile);
      TestData data =  gson.fromJson(fileReader, TestData.class);


        List<Object[]> dataToReturn = new ArrayList<Object[]>();
        for(User user: data.getData()){
            dataToReturn.add(new Object[] {user});
        }
        return dataToReturn.iterator();
    }

    @DataProvider(name = "LoginDataProviderCSV")
    public Iterator<User> loginDataProviderCSV() {
        return CSVReaderUtility.readCSV("loginData.csv");
    }

    @DataProvider(name = "LoginDataProviderExcel")
    public Iterator<User> loginDataProviderExcel() {
        return ExcelReaderUtility.readExcelFile("loginData.xlsx");
    }
}
