package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

@Epic("Swag Labs")
@Feature("Авторизация")
@Owner("Ирина Зуева")
@TmsLink("Test_project")
public class LoginTest extends BaseTest {
    @Story("Вход с валидными данными")
    @Test
    public void checkLogin() {
        loginPage
                .open()
                .login(withAdminPermission());
        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName());
    }

    @Story("Вход с невалидными данными")
    @Test(dataProvider = "incorrectData")
    public void checkIncorrectLogin(User user, String errMsg) {
        loginPage
                .open()
                .login(user);
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails appear");
        assertEquals(loginPage.getErrorMsg(), errMsg);
    }

    @DataProvider(name = "incorrectData")
    public Object[][] loginData() {
        return new Object[][]{
                {withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {withEmptyLogin(), "Epic sadface: Username is required"},
                {withEmptyPassword(), "Epic sadface: Password is required"},
                {withIncorrectPermission(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
