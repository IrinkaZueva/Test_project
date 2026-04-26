package pages;

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

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void clickCancel() {
        driver.findElement(cancelBtn).click();
    }

    public boolean isDisplayed() {
        return driver.findElement(formCheckout).isDisplayed();
    }

    public void fillForma(String firstName, String lastName, String zipcode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(zipcode);
        clickContinue();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }

    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }
}
