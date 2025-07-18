package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.constants.Browser.CHROME;

public class BaseTest {
    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest;

    @Parameters({"browser","isLambdaTest", "isHeadless"})
    @BeforeMethod(description = "Load the Homepage of the website")
    public void setUp(@Optional("chrome") String browser,@Optional("false") boolean isLambdaTest,@Optional("false") boolean isHeadless, ITestResult result) {
        WebDriver lambdaDriver;
        this.isLambdaTest = isLambdaTest;
        if (isLambdaTest) {
            lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
        } else {
            logger.info("Load the Homepage of the website");
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isLambdaTest);
        }
    }

    public BrowserUtility getInstance() {
        return homePage;
    }

    @AfterMethod(description = "Close the browser")
    public void tearDown() {
        logger.info("Closing the browser");
        if (isLambdaTest) {
            LambdaTestUtility.quitSession();
        } else {
            homePage.closeBrowser();
        }
    }
}
