package com.ui.tests;

import static com.constants.Browser.*;
import static org.testng.Assert.*;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {

    HomePage homePage;

    @BeforeMethod(description = "Load the Homepage of the website")
    public void setUp() {
        homePage = new HomePage(CHROME);
    }

    @Test(description = "Verify user can login with valid credentials", groups = {"e2e", "sanity"},
            dataProvider = "LoginDataProvider", dataProviderClass = com.ui.dataProviders.LoginDataProvider.class)
    public void loginTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Balanand Jha");
    }

    @Test(description = "Verify user can login with valid credentials", groups = {"e2e", "sanity"},
            dataProvider = "LoginDataProviderCSV", dataProviderClass = com.ui.dataProviders.LoginDataProvider.class)
    public void logincsvTest(User user) {
         assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Balanand Jha");
    }

    @Test(description = "Verify user can login with valid credentials", groups = {"e2e", "sanity"},
            dataProvider = "LoginDataProviderExcel", dataProviderClass = com.ui.dataProviders.LoginDataProvider.class)
    public void loginExcelTest(User user) {
         assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Balanand Jha");
    }
}
