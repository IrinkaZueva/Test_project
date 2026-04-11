package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By CartBtn = By.cssSelector("[data-test='shopping-cart-link']");
    private final By titlePage = By.cssSelector("[data-test='title']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void GoToCart() {
        driver.findElement(CartBtn).click();
    }

    public String getTitle() {
        return driver.findElement(titlePage).getText();
    }
}
