package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static enums.TitleNaming.CART;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Swag Labs")
@Feature("Корзина")
@Owner("Ирина Зуева")
@TmsLink("Test_project")
public class CartTest extends BaseTest {
    @Story("Переход в корзину")
    @Test
    public void checkGoCart() {
        loginPage
                .open()
                .login(withAdminPermission());
        assertTrue(productsPage.pageTitleDisplayed());
        cartPage.navigationPanel.goToCart();
        assertEquals(cartPage.getTitle(), CART.getDisplayName());
    }

    @Story("Добавление товаров")
    @Test
    public void checkGoodsInCart() {
        final String goodsName = "Sauce Labs Bike Light";
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart(goodsName);
        assertEquals(productsPage.checkBtnName(goodsName), "Remove");
        productsPage.navigationPanel.goToCart();
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 1);
        assertTrue(cartPage.getProductsNames().contains(goodsName));
    }
}
