//package com.ui.tests;
//
//import com.utility.BrowserUtility;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//import java.time.Duration;
//
//public class LoginTest {
//    public static void main(String[] args) throws InterruptedException {
//
//        WebDriver driver = new ChromeDriver();
//
//        BrowserUtility browserUtility = new BrowserUtility(driver);
//        browserUtility.goToWebsite("http://www.automationpractice.pl/index.php");
//        browserUtility.maximizeWindow();
//
//
//        browserUtility.timeoutImplicitlyWait(10);
//        By signInButtonLocator = By.cssSelector("a.login");
//        browserUtility.clickOnElement(signInButtonLocator);
//
//
//        By emailInputLocator = By.id("email");
//        browserUtility.enterTextToElement(emailInputLocator,"fofege2940@dxirl.com");
//
//        By passwordInputLocator = By.id("passwd");
//        browserUtility.enterTextToElement(passwordInputLocator,"password");
//
//        By signInSubmitButtonLocator = By.id("SubmitLogin");
//        browserUtility.clickOnElement(signInSubmitButtonLocator);
//
//        Thread.sleep(2000);
//
//
//        driver.close();
//
//
//    }
//
//
//}
