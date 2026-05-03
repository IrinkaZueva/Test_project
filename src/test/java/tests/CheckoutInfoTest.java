package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static enums.TitleNaming.CART;
import static enums.TitleNaming.CHECKOUT;
import static enums.UserData.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

@Epic("Swag Labs")
@Feature("Оформление заказа")
@Owner("Ирина Зуева")
@TmsLink("Test_project")
public class CheckoutInfoTest extends BaseTest {
    @Story("Форма оформления заказа")
    @Test
    public void checkCheckoutInfo() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart();
        cartPage.proceedToCheckout();
        assertEquals(cartPage.getTitle(), CHECKOUT.getDisplayName());
        assertTrue(checkoutInfoPage.isDisplayed());
    }

    @Story("Наличие ошибки при невалидных данных")
    @Test(dataProvider = "incorrectFields")
    public void checkIncorrectFields(String firstName, String lastName, String zipcode, String errMsg) {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart();
        cartPage.proceedToCheckout();
        checkoutInfoPage.fillForma(firstName, lastName, zipcode);
        assertTrue(checkoutInfoPage.isErrorMsgDisplayed(), "The error message fails appear");
        assertEquals(checkoutInfoPage.getErrorMsg(), errMsg);
    }

    @DataProvider(name = "incorrectFields")
    public Object[][] fieldsData() {
        return new Object[][]{
                {UNVALID_FIRST_NAME.getValue(), VALID_LAST_NAME.getValue(), VALID_ZIP_CODE.getValue(), "Error: First Name is required"},
                {VALID_FIRST_NAME.getValue(), UNVALID_LAST_NAME.getValue(), VALID_ZIP_CODE.getValue(), "Error: Last Name is required"},
                {VALID_FIRST_NAME.getValue(), VALID_LAST_NAME.getValue(), UNVALID_ZIP_CODE.getValue(), "Error: Postal Code is required"},
        };
    }

    @Story("Отмена оформления заказа")
    @Test
    public void checkCheckoutCancel() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart();
        cartPage.proceedToCheckout();
        checkoutInfoPage.clickCancel();
        assertEquals(cartPage.getTitle(), CART.getDisplayName());
    }
}
