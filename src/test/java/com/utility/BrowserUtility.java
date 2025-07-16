package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);
    }
    public BrowserUtility(String browserName) {
        logger.info("Launching the browser: " + browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            // Initialize Firefox driver here
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("edge")) {
            // Initialize Edge driver here
            driver.set(new EdgeDriver());
        } else {
            logger.error("Browser not supported: " + browserName);
            throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
    }
        public BrowserUtility(Browser browserName) {
            logger.info("Launching the browser "+browserName);// Initialize the WebDriver based on the browser type
            if(browserName==Browser.CHROME) {
                driver.set(new ChromeDriver());
            } else if(browserName==Browser.FIREFOX) {
                // Initialize Firefox driver here
                driver.set(new FirefoxDriver());
            } else if(browserName==Browser.EDGE) {
                // Initialize Edge driver here
                driver.set(new EdgeDriver());
            } else {
                logger.error("Browser not supported: " + browserName);
                throw new IllegalArgumentException("Browser not supported: " + browserName);
            }
        }


    public void goToWebsite(String url) {
        logger.info("Navigating to URL: " + url);
        driver.get().get(url);
    }
    public void maximizeWindow() {
        logger.info("Maximizing browser window");
        driver.get().manage().window().maximize();
    }
    public void timeoutImplicitlyWait(long seconds) {
        driver.get().manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(seconds));
    }
    public void clickOnElement(By locator) {
        logger.info("Clicking on element: " + locator);
        driver.get().findElement(locator).click();
    }
    public void enterTextToElement(By locator, String text) {
        logger.info("Entering text '" + text + "' into element: " + locator);
        driver.get().findElement(locator).sendKeys(text);
    }
    public String getVisibleText(By locator) {
        logger.info("Getting visible text from element: " + locator);
        return driver.get().findElement(locator).getText();
    }
    public void closeBrowser() {
        logger.info("Closing the browser");
        if (driver != null) {
            driver.get().quit();
        }
    }
    public String takeScreenshot(String fileName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String timestamp = format.format(date);
        String path = System.getProperty("user.dir") + "//screenshots//" + fileName + "-" + timestamp + ".png";
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

}
