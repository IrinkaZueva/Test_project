package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private final By userField = By.cssSelector("[id='user-name']");
    private final By passwordField = By.xpath("//*[@placeholder='Password']");
    private final By submitButton = By.cssSelector(DATA_TEST_PATTERN.formatted("login-button"));
    private final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие сайта")
    public LoginPage open() {
        driver.get(BASE_URL);

        return this;
    }

    @Step("Логинимся под кредами пользователя")
    public LoginPage login(User user) {
        fillLoginField(user.getLogin());
        fillPasswordField(user.getPassword());
        clickButton();

        return this;
    }

    @Step("Заполняем поле ввода логина {login}")
    public LoginPage fillLoginField(String login) {
        driver.findElement(userField).sendKeys(login);

        return this;
    }

    @Step("Заполняем поле ввода пароля {password}")
    public LoginPage fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);

        return this;
    }

    @Step("Нажимаем кнопку Login")
    public LoginPage clickButton() {
        driver.findElement(submitButton).click();

        return this;
    }

    @Step("Получаем текст из сообщения об ошибке")
    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }

    @Step("Проверяем отображение сообщения об ошибке")
    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    @Step("Проверяем отображение кнопки Login")
    public boolean isLoginBtnDisplayed() {
        return driver.findElement(submitButton).isDisplayed();
    }
}
