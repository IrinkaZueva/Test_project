package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {
    @Test
    public void checkGoCart() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.pageTitleDisplayed());
        cartPage.navigationPanel.goToCart();
        assertEquals(cartPage.getTitle(), "Your Cart");
    }

    @Test
    public void checkGoodsInCart() {
        final String goodsName = "Sauce Labs Bike Light";
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart(goodsName);
        assertEquals(productsPage.checkBtnName(goodsName), "Remove");
        productsPage.navigationPanel.goToCart();
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 1);
        assertTrue(cartPage.getProductsNames().contains(goodsName));
    }
}
