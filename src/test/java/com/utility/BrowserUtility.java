package com.utility;

import com.constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BrowserUtility {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver = driver;
    }
    public BrowserUtility(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            // Initialize Firefox driver here
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            // Initialize Edge driver here
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
    }
        public BrowserUtility(Browser browserName) {
            if(browserName==Browser.CHROME) {
                driver = new ChromeDriver();
            } else if(browserName==Browser.FIREFOX) {
                // Initialize Firefox driver here
                driver = new FirefoxDriver();
            } else if(browserName==Browser.EDGE) {
                // Initialize Edge driver here
                driver = new EdgeDriver();
            } else {
                throw new IllegalArgumentException("Browser not supported: " + browserName);
            }
        }


    public void goToWebsite(String url) {
        driver.get(url);
    }
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
    public void timeoutImplicitlyWait(long seconds) {
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(seconds));
    }
    public void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }
    public void enterTextToElement(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
    public String getVisibleText(By locator) {
        return driver.findElement(locator).getText();
    }

}
