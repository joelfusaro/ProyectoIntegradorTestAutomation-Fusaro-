package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class FlujoPrincipalSteps {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;

    @Given("el usuario está en la página de Login de OrangeHRM")
    public void elUsuarioEstaEnLaPaginaDeLogin() {
        loginPage = new LoginPage(Hooks.driver);
        dashboardPage = new DashboardPage(Hooks.driver);
        pimPage = new PIMPage(Hooks.driver);

        loginPage.goTo();
        // isPageLoaded() se resuelve en tiempo de ejecución según el tipo real
        // del objeto (polimorfismo): acá corre la versión de LoginPage.
        Assert.assertTrue(loginPage.isPageLoaded(), "No se cargó la página de Login");
    }

    @When("ingresa credenciales válidas {string} y {string}")
    public void ingresaCredencialesValidas(String usuario, String password) {
        loginPage.loginAs(usuario, password);
    }

    @When("ingresa credenciales inválidas {string} y {string}")
    public void ingresaCredencialesInvalidas(String usuario, String password) {
        loginPage.loginAs(usuario, password);
    }

    @Then("debería ver el Dashboard")
    public void deberiaVerElDashboard() {
        dashboardPage.waitForUrlContains("/dashboard/index");
        // Misma llamada isPageLoaded(), ahora resuelta con la versión de DashboardPage.
        Assert.assertTrue(dashboardPage.isPageLoaded(), "No se llegó al Dashboard");
    }

    @And("navega al módulo PIM")
    public void navegaAlModuloPIM() {
        dashboardPage.goToPIM();
        Assert.assertTrue(pimPage.isPageLoaded(), "No se llegó al módulo PIM");
    }

    @And("busca al empleado {string}")
    public void buscaAlEmpleado(String nombreEmpleado) {
        pimPage.searchEmployeeByName(nombreEmpleado);
    }

    @Then("debería ver resultados de la búsqueda")
    public void deberiaVerResultadosDeLaBusqueda() {
        Assert.assertTrue(pimPage.hasResults(), "No se encontraron resultados para el empleado buscado");
    }

    @And("cierra sesión")
    public void cierraSesion() {
        dashboardPage.logout();
    }

    @Then("debería volver a la página de Login")
    public void deberiaVolverALaPaginaDeLogin() {
        loginPage.waitForUrlContains("/auth/login");
        Assert.assertTrue(loginPage.isPageLoaded(), "No se volvió a la página de Login tras el logout");
    }

    @Then("debería ver un mensaje de error")
    public void deberiaVerUnMensajeDeError() {
        Assert.assertTrue(loginPage.isErrorDisplayed(), "No se mostró el mensaje de credenciales inválidas");
    }
}
