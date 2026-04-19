package pages;

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

    public void goToCart() {
        driver.findElement(cartBtn).click();
    }

    public void openBurgerMenu() {
        driver.findElement(burgerBtn).click();
    }

    public void logout() {
        driver.findElement(logoutMenuItem).click();
    }
}
