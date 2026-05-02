package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    private final By payInfo = By.cssSelector(DATA_TEST_PATTERN.formatted("payment-info-label"));
    private final By finishBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("finish"));
    private final By completeHeader = By.cssSelector(DATA_TEST_PATTERN.formatted("complete-header"));
    private final By backHomeBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("back-to-products"));

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем отображение формы оплаты")
    public boolean isDisplayedPayInfo() {
        return driver.findElement(payInfo).isDisplayed();
    }

    @Step("Проверяем отображение сообщения об успешном оформлении заказа")
    public boolean isDisplayedCompleteHeader() {
        return driver.findElement(completeHeader).isDisplayed();
    }

    @Step("Кликаем по кнопке Finish")
    public CheckoutOverviewPage clickFinish() {
        driver.findElement(finishBtn).click();

        return this;
    }

    @Step("Кликаем по кнопке Back Home")
    public CheckoutOverviewPage clickBackHome() {
        driver.findElement(backHomeBtn).click();

        return this;
    }
}
