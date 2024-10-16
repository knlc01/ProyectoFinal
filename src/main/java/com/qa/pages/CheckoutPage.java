package com.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/*
    Clase que gestiona el proceso de checkout, incluyendo la entrada de datos del comprador y la finalización
     de la compra, con validación de confirmación.
*/
public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void completarFormulario(String firstName, String lastName, String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeInput)).sendKeys(postalCode);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void finalizarCompra() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }
    public void irACheckout() {
        WebElement botonCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        botonCheckout.click();
    }

    public String obtenerMensajeConfirmacion() {
        WebElement mensajeConfirmacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.complete-header")));
        return mensajeConfirmacion.getText();
    }

}

