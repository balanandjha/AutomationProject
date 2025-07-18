package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends BrowserUtility {
    private static final By USER_NAME_LOCATOR = By.cssSelector("a[title='View my customer account'] span");
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(USER_NAME_LOCATOR));
        return userNameElement.getText();
    }
}
