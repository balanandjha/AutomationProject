package com.ui.tests;

import com.constants.Size;
import com.ui.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCheckoutTest extends BaseTest{
    private static final String SEARCH_TERM = "Printed Summer Dress";
    private SearchResultPage searchPageResult;

    @BeforeMethod(description = "User Logs into the application and searches for a product")
    public void setUp() {
        searchPageResult= homePage.goToLoginPage().doLoginWithValidCredentials("fofege2940@dxirl.com","password")
                .productSearch(SEARCH_TERM);
    }

    @Test(description = "Checkout a product with valid details", groups = {"e2e", "smoke","sanity"})
    public void checkoutTest() {
      String result =  searchPageResult.clickOnProductAtIndex(2).selectSize(Size.M).clickAddToCart().proceedToCheckout().goToConfirmAddressPage().goToShippingPage()
                .goToPaymentPage().makePaymentByWire();
        Assert.assertEquals(result, "Your order on My Shop is complete.");



    }
}
