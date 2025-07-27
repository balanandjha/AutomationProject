package com.ui.tests;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewAddressTest extends BaseTest {

    private MyAccountPage myAccountPage;
    private AddressPage addressPage;
    private AddressPOJO address;

    @BeforeMethod(description = "Login to the application before each test")
    public void setUp() {
        myAccountPage = homePage.goToLoginPage().doLoginWithValidCredentials("fofege2940@dxirl.com", "password");
        address = FakeAddressUtility.getFakeAddress();
    }

    @Test
    public void addNewAddressTest(){
     String newAddress =  myAccountPage.goToAddressPage().saveAddress(address);
        Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
    }

}
