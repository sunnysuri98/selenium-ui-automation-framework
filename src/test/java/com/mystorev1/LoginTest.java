package com.mystorev1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.IndexPage;
import pages.LoginPage;
import pages.UserProfilePage;

public class LoginTest extends TestBase {

    @Test(description = "Verify user is able to login into the portal")
    public void loginWithValidCredentials() {

        IndexPage indexPage = new IndexPage(driver);
        UserProfilePage profile = new UserProfilePage(driver);

        indexPage.clickOnsignInButton();

        log.info("User is on login page");

        LoginPage login = new LoginPage(driver);

        login.fillEmail("adam.levine@outlook.com");
        login.fillPassword("Testing@123");

        log.info("user eneted the username and password");

        login.clickOnLoginButton();

        log.info("user clicked on login button");

        Assert.assertTrue(profile.getName().contains("adam"));

        log.info("user successfully logged into the application");

    }

}
