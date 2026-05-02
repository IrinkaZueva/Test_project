package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static enums.TitleNaming.*;
import static enums.UserData.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

@Epic("Swag Labs")
@Feature("Подтверждение заказа")
@Owner("Ирина Зуева")
@TmsLink("Test_project")
public class CheckoutOverviewTest extends BaseTest {
    @Story("Страница подтверждения заказа")
    @Test
    public void checkCheckoutOverview() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart();
        cartPage.proceedToCheckout();
        checkoutInfoPage.fillForma(VALID_FIRST_NAME.getValue(), VALID_LAST_NAME.getValue(), VALID_ZIP_CODE.getValue());
        assertTrue(checkoutOverviewPage.isDisplayedPayInfo());
        assertEquals(checkoutOverviewPage.getTitle(), OVERVIEW.getDisplayName());
    }

    @Story("Страница завершения оформления заказа")
    @Test
    public void checkCheckoutComplete() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart();
        cartPage.proceedToCheckout();
        checkoutInfoPage.fillForma(VALID_FIRST_NAME.getValue(), VALID_LAST_NAME.getValue(), VALID_ZIP_CODE.getValue());
        checkoutOverviewPage.clickFinish();
        assertTrue(checkoutOverviewPage.isDisplayedCompleteHeader());
        assertEquals(checkoutOverviewPage.getTitle(), COMPLETE.getDisplayName());
    }

    @Story("Возврат на главную страницу")
    @Test
    public void checkBackToProducts() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart();
        cartPage.proceedToCheckout();
        checkoutInfoPage.fillForma(VALID_FIRST_NAME.getValue(), VALID_LAST_NAME.getValue(), VALID_ZIP_CODE.getValue());
        checkoutOverviewPage
                .clickFinish()
                .clickBackHome();
        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName());
    }
}
