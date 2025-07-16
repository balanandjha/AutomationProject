package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtitlity {
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public static ExtentReports setUpExtentReport(String reportFileName) {
        if (extentReports == null) {
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//" + reportFileName);
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
        }
        return extentReports;
    }

    public static ExtentTest createExtentTest(String testName) {
        if (extentReports == null) {
            setUpExtentReport("report.html");
        }
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
        return test;
    }

    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    public static void flush() {
        if (extentReports != null) {
            extentReports.flush();
            extentTest.remove();
        }
    }
}
