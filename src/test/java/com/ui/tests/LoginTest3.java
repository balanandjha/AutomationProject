package com.ui.tests;

import static com.constants.Browser.*;
import static org.testng.Assert.*;
import com.ui.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest3 {

    HomePage homePage;

    @BeforeMethod(description = "Load the Homepage of the website")
    public void setUp() {
        homePage = new HomePage(CHROME);
    }

    @Test(description = "Verify user can login with valid credentials", groups = {"e2e", "sanity"})
    public void loginTest() {
        assertEquals(homePage.goToLoginPage().doLoginWith("fofege2940@dxirl.com", "password").getUserName(), "Balanand Jha");
    }
}
