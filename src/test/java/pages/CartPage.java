package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private final By product = By.cssSelector(".inventory_item_name");
    private final By continueShoppingBtn = By.id("continue-shopping");
    private final By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получаем список товаров")
    public ArrayList<String> getProductsNames() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingBtn));
        List<WebElement> allProducts = driver.findElements(product);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }

    @Step("Кликаем Checkout")
    public CartPage clickCheckout() {
        driver.findElement(checkoutBtn).click();

        return this;
    }

    @Step("Оформляем заказ из корзины")
    public CartPage proceedToCheckout() {
        navigationPanel.goToCart();
        clickCheckout();

        return this;
    }
}
