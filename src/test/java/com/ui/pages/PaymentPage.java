package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BrowserUtility {
    private static final By PAYMENT_BY_BANK_WIRE_LOCATOR = By.xpath("//a[@title='Pay by bank wire']");
    private static final By CONFIRM_PAYMENT_BUTTON_LOCATOR = By.cssSelector("button[class='button btn btn-default button-medium']");
    private static final By ALERT_MESSAGE_LOCATOR = By.cssSelector("p.alert.alert-success");


    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    public String makePaymentByWire() {
        clickOnElement(PAYMENT_BY_BANK_WIRE_LOCATOR);
        clickOnElement(CONFIRM_PAYMENT_BUTTON_LOCATOR);
        return getVisibleText(ALERT_MESSAGE_LOCATOR);
    }
}
