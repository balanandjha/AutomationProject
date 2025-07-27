package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BrowserUtility {
   private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
    private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
    private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
    private static final By ERROR_MESSAGE_LOCATOR = By.cssSelector("div.alert.alert-danger li");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWithValidCredentials(String email, String password) {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        enterTextToElement(EMAIL_TEXT_BOX_LOCATOR, email);
        enterTextToElement(PASSWORD_TEXT_BOX_LOCATOR, password);
        clickOnElement(SUBMIT_BUTTON_LOCATOR);
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;
    }

    public LoginPage doLoginWithInvalidCredentials(String email, String password) {
        enterTextToElement(EMAIL_TEXT_BOX_LOCATOR, email);
        enterTextToElement(PASSWORD_TEXT_BOX_LOCATOR, password);
        clickOnElement(SUBMIT_BUTTON_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;

    }
    public String getErrorMessage() {
        return getVisibleText(ERROR_MESSAGE_LOCATOR);
    }
}
