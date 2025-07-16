package com.ui.listeners;

import com.constants.Env;
import com.utility.JSONUtility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalazer implements IRetryAnalyzer {
    //private static final int MAX_NUMBER_OF_ATTEMPS = Integer.parseInt(PropertiesUtil.readProperty(Env.DEV,"MAX_NUMBER_OF_ATTEMPS"));
    private static final int MAX_NUMBER_OF_ATTEMPS = JSONUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
    private static int currentAttempt = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(currentAttempt < MAX_NUMBER_OF_ATTEMPS) {
            currentAttempt++;
            return true;
        }
        return false;
    }
}
