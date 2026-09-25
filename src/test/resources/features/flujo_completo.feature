Feature: Flujo completo en OrangeHRM
  Como usuario administrador de OrangeHRM
  Quiero poder loguearme, buscar empleados y salir del sistema
  Para validar el flujo principal de la aplicación

  Background:
    Given el usuario está en la página de Login de OrangeHRM

  Scenario: Login exitoso
    When ingresa credenciales válidas "Admin" y "admin123"
    Then debería ver el Dashboard

  Scenario: Buscar empleado
    When ingresa credenciales válidas "Admin" y "admin123"
    And navega al módulo PIM
    And busca al empleado "John"
    Then debería ver resultados de la búsqueda

  Scenario: Flujo completo E2E
    When ingresa credenciales válidas "Admin" y "admin123"
    And navega al módulo PIM
    And busca al empleado "John"
    And cierra sesión
    Then debería volver a la página de Login

  Scenario: Login con credenciales inválidas
    When ingresa credenciales inválidas "Admin" y "claveIncorrecta"
    Then debería ver un mensaje de error
