package com.ui.pages;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BrowserUtility {

    private static final By COMPANY_LOCATOR = By.id("company");
    private static final By ADDRESS1_LOCATOR = By.id("address1");
    private static final By ADDRESS2_LOCATOR = By.id("address2");
    private static final By CITY_LOCATOR = By.id("city");
    private static final By POSTAL_CODE_LOCATOR = By.id("postcode");
    private static final By HOME_PHONE_NUMBER_LOCATOR = By.id("phone");
    private static final By MOBILE_PHONE_NUMBER_LOCATOR = By.id("phone_mobile");
    private static final By OTHER_INFORMATION_TEXTAREA_LOCATOR = By.id("other");
    private static final By ADDRESS_ALIAS_LOCATOR = By.id("alias");
    private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
    private static final By SAVE_ADDRESS_BUTTON_LOCATOR = By.id("submitAddress");
    private static final By ADDRESS_HEADING_LOCATOR = By.tagName("h3");

    public AddressPage(WebDriver driver){
        super(driver);
    }

    public String saveAddress(AddressPOJO addressPOJO) {
        enterTextToElement(COMPANY_LOCATOR, addressPOJO.getCompany());
        enterTextToElement(ADDRESS1_LOCATOR, addressPOJO.getAddressLine1());
        enterTextToElement(ADDRESS2_LOCATOR, addressPOJO.getAddressLine2());
        enterTextToElement(CITY_LOCATOR, addressPOJO.getCity());
        selectFromDropDown(STATE_DROPDOWN_LOCATOR, addressPOJO.getState());
        enterTextToElement(POSTAL_CODE_LOCATOR, addressPOJO.getPostalCode());
        enterTextToElement(HOME_PHONE_NUMBER_LOCATOR, addressPOJO.getHomePhoneNumber());
        enterTextToElement(MOBILE_PHONE_NUMBER_LOCATOR, addressPOJO.getMobilePhoneNumber());
        enterTextToElement(OTHER_INFORMATION_TEXTAREA_LOCATOR, addressPOJO.getOtherInformation());
        clearTextFromElement(ADDRESS_ALIAS_LOCATOR);
        enterTextToElement(ADDRESS_ALIAS_LOCATOR, addressPOJO.getAddressAlias());
        clickOnElement(SAVE_ADDRESS_BUTTON_LOCATOR);
        String newAddressHeading = getVisibleText(ADDRESS_HEADING_LOCATOR);
        return newAddressHeading;

    }
}
