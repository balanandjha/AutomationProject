package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private WebDriverWait wait;

    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
    }
    public BrowserUtility(String browserName) {
        logger.info("Launching the browser: " + browserName);

        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else if (browserName.equalsIgnoreCase("firefox")) {
            // Initialize Firefox driver here
            driver.set(new FirefoxDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else if (browserName.equalsIgnoreCase("edge")) {
            // Initialize Edge driver here
            driver.set(new EdgeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else {
            logger.error("Browser not supported: " + browserName);
            throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
    }
        public BrowserUtility(Browser browserName) {
            logger.info("Launching the browser "+browserName);// Initialize the WebDriver based on the browser type
            if(browserName==Browser.CHROME) {
                driver.set(new ChromeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else if(browserName==Browser.FIREFOX) {
                // Initialize Firefox driver here
                driver.set(new FirefoxDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else if(browserName==Browser.EDGE) {
                // Initialize Edge driver here
                driver.set(new EdgeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else {
                logger.error("Browser not supported: " + browserName);
                throw new IllegalArgumentException("Browser not supported: " + browserName);
            }
        }

    public BrowserUtility(Browser browserName,boolean isHeadless) {
        logger.info("Launching the browser "+browserName);// Initialize the WebDriver based on the browser type
        if(browserName==Browser.CHROME ) {
            if(isHeadless) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            driver.set(new ChromeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
            else {
                driver.set(new ChromeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }

        } else if(browserName==Browser.FIREFOX) {
            if (isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-gpu");
                driver.set(new FirefoxDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else {
                // Initialize Firefox driver here
                driver.set(new FirefoxDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        }
        else if(browserName==Browser.EDGE) {
            if (isHeadless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-gpu");
                driver.set(new EdgeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else {
                // Initialize Edge driver here
                driver.set(new EdgeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
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
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        logger.info("Clicking on element: " + locator);
        driver.get().findElement(locator).click();
    }
    public void clickOnCheckBoxElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Clicking on element: " + locator);
        driver.get().findElement(locator).click();
    }

    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        logger.info("Clicking on element: " + element);
        element.click();
    }
    public void enterTextToElement(By locator, String text) {
        logger.info("Entering text '" + text + "' into element: " + locator);
        driver.get().findElement(locator).sendKeys(text);
    }
    public String getVisibleText(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Getting visible text from element: " + locator);
        return driver.get().findElement(locator).getText();
    }
    public String getVisibleText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("Getting visible text from element: " + element);
        return element.getText();
    }

    public List<String> getAllVisibleText(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Getting all visible text from element: " + locator);
        List<WebElement> elementList = driver.get().findElements(locator);
        List<String> visibleTextList = new ArrayList<String>();
        for (WebElement element : elementList) {
            System.out.println(getVisibleText(element));
            visibleTextList.add(getVisibleText(element));
        }
        return visibleTextList;
    }
    public List<WebElement> getAllElements(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Getting all elements from: " + locator);
        List<WebElement> elementList = driver.get().findElements(locator);

        return elementList;
    }
    public void closeBrowser() {
        logger.info("Closing the browser");
        if (driver != null) {
            driver.get().quit();
        }
    }
    public String takeScreenshot(String fileName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String timestamp = format.format(date);
        String path = "./screenshots/" + fileName + "-" + timestamp + ".png";
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

    public void selectFromDropDown(By locator, String optionToSelect) {
        logger.info("Selecting from dropdown by visible text: " + optionToSelect + " in element: " + locator);
        WebElement dropdownElement = driver.get().findElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(optionToSelect);
      /*  dropdownElement.click();
        List<WebElement> options = dropdownElement.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.getText().equals(optionToSelect)) {
                option.click();
                break;
            }
        } */

        }

        public void clearTextFromElement(By locator) {
            logger.info("Clearing text from element: " + locator);
            WebElement element = driver.get().findElement(locator);
            element.clear();
        }


}
