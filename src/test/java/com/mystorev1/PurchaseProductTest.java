package com.mystorev1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.IndexPage;
import pages.LoginPage;
import pages.OrderConfirmedPage;
import pages.ProductPage;
import pages.SearchResultsPage;
import pages.UserProfilePage;
import utils.FakeData;

public class PurchaseProductTest extends TestBase {

    @Test(description = "verify user is able to buy product")
    public void purchaseProduct() {

        log.info("user is on index page");
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnsignInButton();

        // -------------------------------------------------------------------------//
        log.info("user is on login page");
        LoginPage login = new LoginPage(driver);
        login.fillEmail("john.cena@gmail.com");
        login.fillPassword("Testing@123");
        login.clickOnLoginButton();
        log.info("user successfylly logged into the application");

        // -------------------------------------------------------------------------//

        UserProfilePage profile = new UserProfilePage(driver);

        profile.fillSearchBar("arts");

        log.info("user entered the search criteria and clicked on search button");

        // -------------------------------------------------------------------------//
        SearchResultsPage results = new SearchResultsPage(driver);
        log.info("search results appear");
        results.clickOnProduct();

        log.info("user clciked on product");

        // -------------------------------------------------------------------------//
        log.info("user is on product detail page");
        ProductPage product = new ProductPage(driver);

        product.selectProductDimension("60x90cm");
        int quantity= FakeData.getRandomNumberBetweenOneAndEight();
        product.fillProductQuanty(String.valueOf(quantity));
        log.info("user selected the quantity and dimension");
        product.clickOnAddToCartButton();

        product.clickOnproceedToCheckoutButton();

        log.info("user clicked on checkout button under dialog");

        // -------------------------------------------------------------------------//

        log.info("user is on cart page");
        CartPage cart = new CartPage(driver);
        cart.clickOnproceedToCheckoutButton();

        log.info("user clicked on procced to checkout button");

        // -------------------------------------------------------------------------//

        log.info("user is on checkout page");
        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.clickOncontinueButtonInsideAddressSection();
        checkout.clickOnontinueButtonInsideShippingSection();
        int no = FakeData.getRandomNumberBetweenOneAndTwo();
        System.out.println(no);
        if (no == 1) {

            checkout.clickOnpayByBankWireRadioButton();

        } else {
            checkout.clickOnpayByCheckRadioButton();
        }
        checkout.clcikOntermsCheckbox();
        checkout.clickOnPlaceOrderButton();

        // -------------------------------------------------------------------------//

        log.info("user is on order confirmed page");
        OrderConfirmedPage order = new OrderConfirmedPage(driver);

        System.out.println(order.getOrderConfirmedMessage());

        Assert.assertTrue(order.getOrderConfirmedMessage().contains("ORDER IS CONFIRMED"));

    }

}
