package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By titlePage = By.cssSelector("[data-test='title']");
    private final By addToCartBtn = By.xpath("//*[text()='Add to cart']");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By cartLink = By.cssSelector("[data-test='shopping-cart-link']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(titlePage).getText();
    }

    public boolean pageTitleDisplayed() {
        return driver.findElement(titlePage).isDisplayed();
    }

    public void addToCart() {
        driver.findElements(addToCartBtn).get(0).click();
    }

    public String checkCounterValue() {
        return driver.findElement(cartBadge).getText();
    }

    public String checkCounterColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }
}
