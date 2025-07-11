package com.ui.pages;

import com.constants.Browser;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserUtility{
    private static final By SIGN_IN_BUTTON_LOCATOR = By.cssSelector("a.login");

    public HomePage(Browser browser) {
        super(browser);
        goToWebsite("http://www.automationpractice.pl/index.php");
    }


    public LoginPage goToLoginPage() {
        clickOnElement(SIGN_IN_BUTTON_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

}
