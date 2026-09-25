package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object del módulo PIM. Extiende BasePage y sobrescribe isPageLoaded().
 */
public class PIMPage extends BasePage {

    private final By employeeNameInput = By.cssSelector("input[placeholder='Type for hints...']");
    private final By firstAutocompleteSuggestion = By.xpath(
            "//div[contains(@class,'oxd-autocomplete-option') and not(contains(.,'Searching'))]"
    );
    private final By searchSubmitButton = By.cssSelector("button[type='submit']");
    private final By resultRows = By.cssSelector(".oxd-table-card");
    private final By noRecordsLabel = By.xpath("//span[text()='No Records Found']");
    private final By pimTitle = By.xpath("//h6[text()='PIM']");

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public void searchEmployeeByName(String employeeName) {
        type(employeeNameInput, employeeName);
        click(firstAutocompleteSuggestion);
        click(searchSubmitButton);
    }

    /** Sobrecarga: arma el nombre completo a partir de nombre y apellido. */
    public void searchEmployeeByName(String firstName, String lastName) {
        searchEmployeeByName(firstName + " " + lastName);
    }

    public boolean hasResults() {
        return isElementVisible(resultRows);
    }

    public boolean isNoRecordsDisplayed() {
        return isElementVisible(noRecordsLabel);
    }

    public boolean isOnPIMPage() {
        return driver.getCurrentUrl().contains("/pim/") || isElementVisible(pimTitle);
    }

    @Override
    public boolean isPageLoaded() {
        return isOnPIMPage();
    }
}
