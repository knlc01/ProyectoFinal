package com.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/*
  La clase LoginPage representa la página de inicio de sesión de una aplicación web.
  Utiliza el patrón Page Object Model (POM) para manejar los elementos y acciones relacionadas con el inicio de sesión.
*/
public class LoginPage {
    private WebDriver driver;// WebDriver para interactuar con el navegador
    private WebDriverWait wait;// WebDriverWait para gestionar tiempos de espera explícitos
    private By textBoxUsuario = By.id("user-name");// Localizador del campo de nombre de usuario
    private By textBoxClave = By.id("password");// Localizador del campo de contraseña
    private By btnLogin = By.id("login-button");// Localizador del botón de inicio de sesión

    /*
     Constructor de la clase LoginPage. Inicializa el WebDriver y establece el tiempo de espera explícito.
     @param driver el WebDriver que se usará para interactuar con los elementos de la página.
    */
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera de 10 segundos
    }
    /*
     Método para esperar y obtener un WebElement de forma segura.
     @param locator El By que representa el localizador del elemento.
     */
    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));//@return El WebElement una vez que es visible.
    }


    /*
     Método para ingresar el nombre de usuario en el campo correspondiente.
     @param usuario el nombre de usuario que se quiere ingresar.
    */
    public void setUsuario(String usuario){
        waitForElement(textBoxUsuario).sendKeys(usuario); // Espera que el campo de usuario sea visible y luego escribe el valor
    }
    /*
     Método para ingresar la contraseña en el campo correspondiente.
     @param clave la contraseña que se quiere ingresar.
    */
    public void setClave(String clave){
        waitForElement(textBoxClave).sendKeys(clave);
    }
    /*
     Método para hacer clic en el botón de inicio de sesión.
    */
    public void clickBtnLogin(){
        driver.findElement(btnLogin).click();// Encuentra el botón de login y hace clic
    }
}
