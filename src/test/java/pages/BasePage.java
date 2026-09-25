package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Clase base abstracta del patrón Page Object Model (POM).
 * Concentra las acciones comunes de Selenium y obliga a cada página
 * concreta a definir su propia condición de "página cargada" mediante
 * el método abstracto isPageLoaded() (herencia + polimorfismo).
 */
public abstract class BasePage {

    private static final int DEFAULT_TIMEOUT_SECONDS = 15;

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
    }

    /** Cada Page Object concreto sobrescribe esta condición de carga. */
    public abstract boolean isPageLoaded();

    // ---------- Acciones comunes, con sobrecarga (overload) ----------

    public void click(By locator) {
        click(locator, DEFAULT_TIMEOUT_SECONDS);
    }

    /** Sobrecarga: permite indicar un timeout puntual distinto al default. */
    public void click(By locator, int timeoutSeconds) {
        waitFor(timeoutSeconds).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void type(By locator, String text) {
        type(locator, text, true);
    }

    /** Sobrecarga: permite decidir si se limpia el campo antes de escribir. */
    public void type(By locator, String text, boolean clearFirst) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (clearFirst) {
            field.clear();
        }
        field.sendKeys(text);
    }

    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public boolean isElementVisible(By locator) {
        return isElementVisible(locator, DEFAULT_TIMEOUT_SECONDS);
    }

    /** Sobrecarga: chequeo de visibilidad con timeout configurable. */
    public boolean isElementVisible(By locator, int timeoutSeconds) {
        try {
            return waitFor(timeoutSeconds)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForUrlContains(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    private WebDriverWait waitFor(int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }
}
