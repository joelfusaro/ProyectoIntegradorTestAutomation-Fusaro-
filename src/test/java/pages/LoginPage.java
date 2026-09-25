package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object de la pantalla de Login. Extiende BasePage (herencia)
 * y sobrescribe (override) isPageLoaded().
 */
public class LoginPage extends BasePage {

    private static final String BASE_URL = "https://opensource-demo.orangehrmlive.com";
    private static final String LOGIN_PATH = "/web/index.php/auth/login";

    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By submitButton = By.cssSelector("button[type='submit']");
    private final By alertMessage = By.cssSelector(".oxd-alert-content-text");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.navigate().to(BASE_URL + LOGIN_PATH);
    }

    public void enterUserName(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void loginAs(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        click(submitButton);
    }

    /** Sobrecarga: login rápido reutilizando las credenciales de administrador. */
    public void loginAs() {
        loginAs("Admin", "admin123");
    }

    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains(LOGIN_PATH);
    }

    public boolean isErrorDisplayed() {
        return isElementVisible(alertMessage);
    }

    @Override
    public boolean isPageLoaded() {
        return isOnLoginPage();
    }
}
