package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;


public class LoginTest3 {
    public static void main(String[] args) {

        HomePage homePage = new HomePage(FIREFOX);
        String username = homePage.goToLoginPage().doLoginWith("fofege2940@dxirl.com", "password").getUserName();
        System.out.println("Logged in as: " + username);

    }
}
