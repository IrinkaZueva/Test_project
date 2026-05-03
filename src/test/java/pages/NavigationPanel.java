package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPanel {
    WebDriver driver;
    private final By cartBtn = By.xpath("//*[@data-test='shopping-cart-link']");
    private final By burgerBtn = By.id("react-burger-menu-btn");
    private final By logoutMenuItem = By.id("logout_sidebar_link");

    public NavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переходим в корзину")
    public NavigationPanel goToCart() {
        driver.findElement(cartBtn).click();

        return this;
    }

    @Step("Открываем бургер-меню")
    public NavigationPanel openBurgerMenu() {
        driver.findElement(burgerBtn).click();

        return this;
    }

    @Step("Выбираем Logout")
    public NavigationPanel logout() {
        driver.findElement(logoutMenuItem).click();

        return this;
    }
}
