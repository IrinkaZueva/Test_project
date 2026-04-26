package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    private final By payInfo = By.cssSelector(DATA_TEST_PATTERN.formatted("payment-info-label"));
    private final By finishBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("finish"));
    private final By completeHeader = By.cssSelector(DATA_TEST_PATTERN.formatted("complete-header"));
    private final By backHomeBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("back-to-products"));
    public static final String validFirstName = "IVAN";
    public static final String validLastName = "IVANOV";
    public static final String validZipCode = "672000";


    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayedPayInfo() {
        return driver.findElement(payInfo).isDisplayed();
    }

    public boolean isDisplayedCompleteHeader() {
        return driver.findElement(completeHeader).isDisplayed();
    }

    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }

    public void clickBackHome() {
        driver.findElement(backHomeBtn).click();
    }
}
