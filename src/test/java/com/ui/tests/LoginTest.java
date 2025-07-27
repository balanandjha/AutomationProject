package com.ui.tests;

import static org.testng.Assert.*;

import com.ui.pojo.User;
import org.testng.annotations.*;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends BaseTest {

    @Test(description = "Verify user can login with valid credentials", groups = {"e2e", "sanity"},
            dataProvider = "LoginDataProvider", dataProviderClass = com.ui.dataProviders.LoginDataProvider.class,
            retryAnalyzer = com.ui.listeners.MyRetryAnalazer.class)
    public void loginTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWithValidCredentials(user.getEmailAddress(), user.getPassword()).getUserName(), "Balanand Jha");
    }

    @Test(description = "Verify user can login with valid credentials", groups = {"e2e", "sanity"},
            dataProvider = "LoginDataProviderCSV", dataProviderClass = com.ui.dataProviders.LoginDataProvider.class,
            retryAnalyzer = com.ui.listeners.MyRetryAnalazer.class)
    public void logincsvTest(User user) {
         assertEquals(homePage.goToLoginPage().doLoginWithValidCredentials(user.getEmailAddress(), user.getPassword()).getUserName(), "Balanand Jha");
    }

    @Test(description = "Verify user can login with valid credentials", groups = {"e2e", "sanity"},
            dataProvider = "LoginDataProviderExcel", dataProviderClass = com.ui.dataProviders.LoginDataProvider.class,
    retryAnalyzer = com.ui.listeners.MyRetryAnalazer.class)
    public void loginExcelTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWithValidCredentials(user.getEmailAddress(), user.getPassword()).getUserName(), "Balanand Jha");

    }


}
