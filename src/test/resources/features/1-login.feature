@regression
Feature: Proceso de inicio de sesión y gestión del carrito
@inicioDeSesion
  Scenario: Inicio de sesión exitoso
    Given ubicado en la pagina de inicio
    When ingreso de usuario y contraseña valido
    And click en el btn login
    Then usuario dirigido a la tienda


