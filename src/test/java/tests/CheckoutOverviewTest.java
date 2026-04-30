package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.CheckoutOverviewPage.*;
import static user.UserFactory.withAdminPermission;

public class CheckoutOverviewTest extends BaseTest {
    @Test
    public void checkCheckoutOverview() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        cartPage.navigationPanel.goToCart();
        cartPage.clickCheckout();
        checkoutInfoPage.fillForma(validFirstName, validLastName, validZipCode);
        assertTrue(checkoutOverviewPage.isDisplayedPayInfo());
        assertEquals(checkoutInfoPage.getTitle(), "Checkout: Overview");
    }

    @Test
    public void checkCheckoutComplete() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        cartPage.navigationPanel.goToCart();
        cartPage.clickCheckout();
        checkoutInfoPage.fillForma(validFirstName, validLastName, validZipCode);
        checkoutOverviewPage.clickFinish();
        assertTrue(checkoutOverviewPage.isDisplayedCompleteHeader());
        assertEquals(checkoutOverviewPage.getTitle(), "Checkout: Complete!");
    }

    @Test
    public void checkBackToProducts() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        cartPage.navigationPanel.goToCart();
        cartPage.clickCheckout();
        checkoutInfoPage.fillForma(validFirstName, validLastName, validZipCode);
        checkoutOverviewPage.clickFinish();
        checkoutOverviewPage.clickBackHome();
        assertEquals(productsPage.getTitle(), "Products");
    }
}
