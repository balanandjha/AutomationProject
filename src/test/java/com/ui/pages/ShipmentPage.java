package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShipmentPage extends BrowserUtility {
    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//button[@name='processCarrier']");
    private static final By TERMS_OF_SERVICE_CHECKBOX_LOCATOR = By.id("uniform-cgv");

    public ShipmentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage goToPaymentPage() {
        clickOnCheckBoxElement(TERMS_OF_SERVICE_CHECKBOX_LOCATOR);
        clickOnElement(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new PaymentPage(getDriver());
    }



}
