package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage {
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By continueBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("continue"));
    private final By zipCodeField = By.id("postal-code");
    private final By cancelBtn = By.id("cancel");
    private final By formCheckout = By.className("checkout_info");
    private final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Кликаем Continue")
    public CheckoutInfoPage clickContinue() {
        driver.findElement(continueBtn).click();

        return this;
    }

    @Step("Кликаем Cancel")
    public CheckoutInfoPage clickCancel() {
        driver.findElement(cancelBtn).click();

        return this;
    }

    @Step("Проверяем отображение формы оформления заказа")
    public boolean isDisplayed() {
        return driver.findElement(formCheckout).isDisplayed();
    }

    @Step("Заполняем форму оформления заказа:имя, фамилия, индекс")
    public CheckoutInfoPage fillForma(String firstName, String lastName, String zipcode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(zipcode);
        clickContinue();

        return this;
    }

    @Step("Получаем текст сообщения об ошибке")
    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }

    @Step("Проверяем отображение сообщения об ошибке")
    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }
}
