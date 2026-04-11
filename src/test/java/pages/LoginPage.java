package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By userField = By.cssSelector("[id='user-name']");
    private final By passwordField = By.xpath("//*[@placeholder='Password']");
    private final By submitButton = By.cssSelector("[data-test='login-button']");
    private final By errorMsg = By.xpath("//*[@data-test='error']");
    private final By isDisplayed = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String login, String password) {
        fillLoginField(login);
        fillPasswordField(password);
        clickButton();

    }

    public void fillLoginField(String login) {
        driver.findElement(userField).sendKeys(login);
    }

    public void fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickButton() {
        driver.findElement(submitButton).click();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }

    public boolean isErrorMsgDisplayed() {
        return driver.findElement(isDisplayed).isDisplayed();
    }
}
