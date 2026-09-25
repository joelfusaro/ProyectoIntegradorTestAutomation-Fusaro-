package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hooks de ciclo de vida de Cucumber (inicialización y cierre del WebDriver).
 * createDriver() está sobrecargado para poder levantar el navegador
 * en modo normal o headless sin duplicar código.
 */
public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        driver = createDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private WebDriver createDriver() {
        return createDriver(false);
    }

    /** Sobrecarga: permite instanciar el driver en modo headless si se necesita. */
    private WebDriver createDriver(boolean headless) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (headless) {
            options.addArguments("--headless=new");
        }
        return new ChromeDriver(options);
    }
}
