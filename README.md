Pagina de prueba https://www.saucedemo.com/
github https://github.com/knlc01/ProyectoFinal
        ProyectoFinal
        │
        ├── src
        │   ├── main
        │   │   ├── drivers
        │   │   │   └── chromedriver.exe
        │   │   └── java
        │   │       └── com.qa
        │   │           ├── pages        # Clases de Page Object Model (POM)
        │   │           │   ├── LoginPage.java  //La clase LoginPage representa la página de inicio de sesión de una aplicación web. Utiliza el patrón Page Object Model (POM) para manejar los elementos y acciones relacionadas con el inicio de sesión.
        │   │           │   ├── ProductsPage.java   //Clase que representa la página de productos, permitiendo seleccionar productos y acceder al carrito para continuar con la compra.
        │   │           │   └── CheckoutPage.java   //Clase que gestiona el proceso de checkout, incluyendo la entrada de datos del comprador y la finalización de la compra, con validación de confirmación
        │   │           │
        │   │           └── utils        # Clases de utilidad (manejo de driver, helper methods, etc.)
        │   │               └── DriverManager.java  //Clase encargada de gestionar la inicialización y finalización del WebDriver, usando WebDriverManager para configurar el driver de Chrome.
        │   └── test
        │       ├── java
        │       │   └── com.qa
        │       │       ├── steps        # Step Definitions de Cucumber
        │       │       │   ├── LoginStep.java  //Clase que define los pasos del login en la aplicación, usando Cucumber para interactuar con la página de inicio de sesión y validar el acceso.
        │       │       │   └── ProductStep.java    //Clase que implementa los pasos para agregar productos al carrito y completar una compra, incluyendo la navegación entre pantallas.
        │       │       │   
        │       │       └── runners      # Clase para correr las pruebas de Cucumber
        │       │           └── RunTest.java    //Clase de ejecución que configura Cucumber para correr los escenarios definidos en los archivos de características.
        │       └── resources
        │           └── features             # Archivos de características en Gherkin
        │               ├── 1-login.feature
        │               └── 2-compra.feature
        │
        ├── pom.xml                          # Archivo de configuración de Maven
        └── README.md                        # Documentación del proyecto
