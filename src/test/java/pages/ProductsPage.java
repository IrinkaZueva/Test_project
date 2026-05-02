package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private final By titlePage = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By addToCartBtn = By.xpath("//*[text()='Add to cart']");
    private final By cartBadge = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем отображение названия страницы")
    public boolean pageTitleDisplayed() {
        return driver.findElement(titlePage).isDisplayed();
    }

    @Step("Добавляем первый товар в корзину")
    public ProductsPage addToCart() {
        driver.findElements(addToCartBtn).getFirst().click();

        return this;
    }

    @Step("Добавляем выбранный товар в корзину")
    public ProductsPage addToCart(final String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();

        return this;
    }

    @Step("Получаем значение количества товаров в корзине")
    public String checkCounterValue() {
        return driver.findElement(cartBadge).getText();
    }

    @Step("Получаем цвет каунтера корзины")
    public String checkCounterColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }

    @Step("Получаем название кнопки")
    public String checkBtnName(final String goodsName) {
        return driver.findElement(By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName))).getText();
    }
}
