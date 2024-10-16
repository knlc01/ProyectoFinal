package com.qa.runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.qa.step",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@regression"  // Se usar etiquetas para ejecutar escenarios específicos.
)
/*
    Clase de ejecución que configura Cucumber para correr los escenarios definidos
     en los archivos de características.
*/
public class RunTest {
}
