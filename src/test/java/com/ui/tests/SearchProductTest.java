package com.ui.tests;

import com.ui.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest  extends BaseTest {
    private MyAccountPage myAccountPage;
    private static final String PRODUCT_NAME = "Printed Summer Dress";


    @BeforeMethod
    public void setUp() {
       myAccountPage = homePage.goToLoginPage().doLoginWithValidCredentials("fofege2940@dxirl.com","password");
    }

  @Test (description = "Verify product search functionality", groups = {"e2e", "sanity"})
    public void verifyProductSearchTest(){
       boolean result = myAccountPage.productSearch(PRODUCT_NAME).isSearchTermPresentInProductList(PRODUCT_NAME);
      Assert.assertEquals(result,true, "Product search failed. Expected product not found in the search results.");


    }
}
