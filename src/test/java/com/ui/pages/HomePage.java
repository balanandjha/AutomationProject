package com.ui.pages;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import static com.utility.PropertiesUtil.*;

import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserUtility{
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static final By SIGN_IN_BUTTON_LOCATOR = By.cssSelector("a.login");

    public HomePage(Browser browser, boolean isHeadless) {
        super(browser, isHeadless);
      //  goToWebsite(readProperty(QA,"URL"));
        goToWebsite(JSONUtility.readJson(QA).getUrl());
    }

    public HomePage(WebDriver driver) {
        super(driver);
        //  goToWebsite(readProperty(QA,"URL"));
        goToWebsite(JSONUtility.readJson(QA).getUrl());
    }


    public LoginPage goToLoginPage() {
        logger.info("Trying to click on Sign In button to go to HomePage");
        clickOnElement(SIGN_IN_BUTTON_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }



}
