package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BrowserUtility {
    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmAddressPage goToConfirmAddressPage() {
        clickOnElement(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new ConfirmAddressPage(getDriver());
    }
}
