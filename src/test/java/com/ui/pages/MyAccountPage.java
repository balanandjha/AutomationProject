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
    private static final By SEARCH_BOX_LOCATOR = By.id("search_query_top");
    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector("button[name='submit_search']");
    private static final By ADD_NEW_ADDRESS_LINK_LOCATOR = By.xpath("//a[@title='Add my first address']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(USER_NAME_LOCATOR));
        return userNameElement.getText();
    }


    public SearchResultPage productSearch(String productName) {

        enterTextToElement(SEARCH_BOX_LOCATOR, productName);
        // Wait for the search button to be clickable before clicking
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON_LOCATOR));
        clickOnElement(SEARCH_BUTTON_LOCATOR);
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        return searchResultPage;
    }

    public AddressPage goToAddressPage() {
        clickOnElement(ADD_NEW_ADDRESS_LINK_LOCATOR);
        return new AddressPage(getDriver());
    }
}
