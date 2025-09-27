package com.mystorev1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountCreationPage;
import pages.LoginPage;
import pages.IndexPage;
import pages.UserProfilePage;
import utils.FakeData;

public class AccountCreationTest extends TestBase {

    @Test(description = "Verify user is able to create new account")
    public void accountCreation() {

        LoginPage loginPage = new LoginPage(driver);
        IndexPage indexPage = new IndexPage(driver);
        AccountCreationPage field = new AccountCreationPage(driver);
        UserProfilePage userProfile = new UserProfilePage(driver);

        log.info("user is on index page");
        indexPage.clickOnsignInButton();

        log.info("user is on login page");

        loginPage.clickOnnewAccountCreationButton();

        log.info("user is on account creation page");

        String firstName = FakeData.firstName();
        String lastName = FakeData.lastName();
        field.fillFirstName(firstName);
        field.fillLastName(lastName);
        field.fillemail(FakeData.email());
        field.fillPassword(FakeData.password());
        field.fillOffersCheckBox();
        field.fillTermsCheckBox();

        log.info("Details are entered");

        field.clickOnSubmitButton();

        log.info("user clicked on save button");

        Assert.assertTrue(userProfile.getName().contains(firstName));
        Assert.assertTrue(userProfile.getName().contains(lastName));

        log.info("Account is successfully created");

    }

}
