@regression
Feature: Proceso completo de compra

  @compraExitosa
  Scenario: Compra de productos exitosa
    Given ubicado en la tienda de productos
    When selecciono productos para agregar al carrito
    And procedo a la pantalla de checkout
    And completo el formulario de información del comprador
    Then la compra se realiza exitosamente
