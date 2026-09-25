package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object del Dashboard. Extiende BasePage y sobrescribe isPageLoaded().
 */
public class DashboardPage extends BasePage {

    private static final String DASHBOARD_PATH = "/dashboard/index";

    private final By breadcrumbHeader = By.cssSelector("h6.oxd-topbar-header-breadcrumb-module");
    private final By userMenuToggle = By.cssSelector(".oxd-userdropdown-tab");
    private final By logoutOption = By.xpath("//a[text()='Logout']");
    private final By pimShortcut = By.cssSelector("a[href*='/pim/viewPimModule']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void goToPIM() {
        click(pimShortcut);
    }

    public void logout() {
        click(userMenuToggle);
        click(logoutOption);
    }

    public boolean isOnDashboard() {
        return driver.getCurrentUrl().contains(DASHBOARD_PATH);
    }

    public String getHeaderText() {
        return getText(breadcrumbHeader);
    }

    @Override
    public boolean isPageLoaded() {
        return isOnDashboard();
    }
}
