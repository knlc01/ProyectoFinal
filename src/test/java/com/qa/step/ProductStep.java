package com.qa.step;
import com.qa.pages.CheckoutPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import com.qa.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

/*
    Clase que implementa los pasos para agregar productos al carrito y completar una compra,
    incluyendo la navegación entre pantallas.
*/
public class ProductStep {
    private WebDriver driver;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;

    public void setUp() {

    }

    @Given("ubicado en la tienda de productos")
    public void ubicado_en_la_tienda_de_productos() {
        driver = DriverManager.getDriver(); // Obtén el driver del DriverManager
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        //inicio de sesion
        LoginPage loginPage;
        loginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        loginPage.setUsuario("standard_user");
        loginPage.setClave("secret_sauce");
        loginPage.clickBtnLogin();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @When("selecciono productos para agregar al carrito")
    public void selecciono_productos_para_agregar_al_carrito() {
        productsPage.agregarProductoAlCarrito("Sauce Labs Backpack");
        productsPage.agregarProductoAlCarrito("Sauce Labs Bike Light");
    }

    @And("procedo a la pantalla de checkout")
    public void procedo_a_la_pantalla_de_checkout() {
        productsPage.irAlCarrito();
        checkoutPage.irACheckout();
    }

    @And("completo el formulario de información del comprador")
    public void completo_el_formulario_de_informacion_del_comprador() {
        checkoutPage.completarFormulario("Kevin", "Lopez", "5000");
        checkoutPage.finalizarCompra();
    }

    @Then("la compra se realiza exitosamente")
    public void la_compra_se_realiza_exitosamente() {
        String mensaje = checkoutPage.obtenerMensajeConfirmacion();
        assertEquals("Thank you for your order!", mensaje);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver(); // Llama al método quitDriver de DriverManager
    }
}
