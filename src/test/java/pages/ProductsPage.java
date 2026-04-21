package pages;

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

    public String getTitle() {
        return driver.findElement(titlePage).getText();
    }

    public boolean pageTitleDisplayed() {
        return driver.findElement(titlePage).isDisplayed();
    }

    public void addToCart() {
        driver.findElements(addToCartBtn).getFirst().click();
    }

    public void addToCart(final String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public String checkCounterValue() {
        return driver.findElement(cartBadge).getText();
    }

    public String checkCounterColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }

    public String checkBtnName(final String goodsName) {
        return driver.findElement(By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName))).getText();
    }
}
