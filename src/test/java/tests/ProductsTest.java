package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.BasePage.BASE_URL;
import static user.UserFactory.withAdminPermission;

@Epic("Swag Labs")
@Feature("Главная страница - Товары")
@Owner("Ирина Зуева")
@TmsLink("Test_project")
public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Onesie",
                    "Sauce Labs Bolt T-Shirt",
                    "Test.allTheThings() T-Shirt (Red)");

    @Story("Добавление товаров в корзину")
    @Test
    public void checkGoodsAdded() {
        loginPage
                .open()
                .login(withAdminPermission());
        assertTrue(productsPage.pageTitleDisplayed());
        for (String goods : goodsList) {
            productsPage.addToCart(goods);
        }
        assertEquals(productsPage.checkCounterValue(), "3");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }

    @Story("Выход из аккаунта")
    @Test
    public void checkLogout() {
        loginPage
                .open()
                .login(withAdminPermission());
        assertTrue(productsPage.pageTitleDisplayed());
        productsPage.navigationPanel
                .openBurgerMenu()
                .logout();
        assertEquals(driver.getCurrentUrl(), BASE_URL);
        assertTrue(loginPage.isLoginBtnDisplayed());
    }
}
