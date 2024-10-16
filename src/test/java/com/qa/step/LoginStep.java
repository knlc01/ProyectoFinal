package com.qa.step;
import com.qa.pages.LoginPage;
import com.qa.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

/*
    Clase que define los pasos del login en la aplicación,
    usando Cucumber para interactuar con la página de inicio de sesión y validar el acceso.
*/
public class LoginStep {
    private WebDriver driver;
    private LoginPage loginPage;

    public void setUp() {

    }

    @Given("ubicado en la pagina de inicio")
    public void ubicado_en_la_pagina_de_inicio(){
        driver = DriverManager.getDriver(); // Obtén el driver del DriverManager
        loginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
    }
    @When("ingreso de usuario y contraseña valido")
    public void ingreso_de_usuario_y_contraseña_valido(){
        loginPage.setUsuario("standard_user");
        loginPage.setClave("secret_sauce");
    }
    @And("click en el btn login")
    public void click_en_el_btn_login(){
        loginPage.clickBtnLogin();
    }
    @Then("usuario dirigido a la tienda")
    public void usuario_dirigido_a_la_tienda(){
       assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver(); // Llama al método quitDriver de DriverManager
    }

}
