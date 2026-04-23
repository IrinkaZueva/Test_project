package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.BasePage.BASE_URL;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Onesie",
                    "Sauce Labs Bolt T-Shirt",
                    "Test.allTheThings() T-Shirt (Red)");

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.pageTitleDisplayed());
        productsPage.addToCart();
        for (String goods : goodsList) {
            productsPage.addToCart(goods);
        }
        assertEquals(productsPage.checkCounterValue(), "4");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }

    @Test
    public void checkLogout() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.pageTitleDisplayed());
        productsPage.navigationPanel.openBurgerMenu();
        productsPage.navigationPanel.logout();
        assertEquals(driver.getCurrentUrl(), BASE_URL);
        assertTrue(loginPage.isLoginBtnDisplayed());
    }
}
