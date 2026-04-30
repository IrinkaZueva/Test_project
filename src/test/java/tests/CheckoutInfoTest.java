package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class CheckoutInfoTest extends BaseTest {
    @Test
    public void checkCheckoutInfo() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        cartPage.navigationPanel.goToCart();
        cartPage.clickCheckout();
        assertEquals(cartPage.getTitle(), "Checkout: Your Information");
        assertTrue(checkoutInfoPage.isDisplayed());
    }

    @Test(dataProvider = "incorrectFields")
    public void checkIncorrectFields(String firstName, String lastName, String zipcode, String errMsg) {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        cartPage.navigationPanel.goToCart();
        cartPage.clickCheckout();
        checkoutInfoPage.fillForma(firstName, lastName, zipcode);
        assertTrue(checkoutInfoPage.isErrorMsgDisplayed(), "The error message fails appear");
        assertEquals(checkoutInfoPage.getErrorMsg(), errMsg);
    }

    @DataProvider(name = "incorrectFields")
    public Object[][] fieldsData() {
        return new Object[][]{
                {"", "IVANOVA", "672000", "Error: First Name is required"},
                {"IVAN", "", "672000", "Error: Last Name is required"},
                {"IVAN", "IVANOV", "", "Error: Postal Code is required"},
        };
    }

    @Test
    public void checkCheckoutCancel() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        cartPage.navigationPanel.goToCart();
        cartPage.clickCheckout();
        checkoutInfoPage.clickCancel();
        assertEquals(cartPage.getTitle(), "Your Cart");
    }
}
