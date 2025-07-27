package com.ui.tests;

import com.ui.pojo.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginInvalidCredentialsTest extends BaseTest {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    private static final String INVALID_EMAIL_ADDRESS = "balanand.jha@test.com";
    private static final String INVALID_PASSWORD = "invalidPassword";

    @Test(description = "Verify if the proper error message when invalid credentials provided", groups = {"e2e", "sanity"})
    public void loginTest() {
    assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD).getErrorMessage(),
            "Authentication failed.");
    }




}
