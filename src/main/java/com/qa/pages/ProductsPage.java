package com.qa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/*
    Clase que representa la página de productos, permitiendo seleccionar productos y acceder al carrito
    para continuar con la compra.
*/
public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera explícita de 10 segundos
    }

    // Método para seleccionar un producto
    public void agregarProductoAlCarrito(String producto) {
        String productoXPath = "//div[text()='" + producto + "']//ancestor::div[@class='inventory_item']//button";
        WebElement botonAgregar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productoXPath)));
        botonAgregar.click();
    }
    public void irAlCarrito() {
        WebElement carrito = wait.until(ExpectedConditions.elementToBeClickable(By.id("shopping_cart_container")));
        carrito.click();
    }

}
