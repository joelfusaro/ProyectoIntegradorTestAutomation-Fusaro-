Proyecto Integrador — Test Automation
Proyecto de automatización de pruebas E2E realizado sobre la aplicación OrangeHRM Demo, como parte del Trabajo Final Integrador de Test Automation.
El proyecto implementa automatización utilizando Selenium WebDriver, Java, Maven, Page Object Model (POM), Programación Orientada a Objetos (POO), Gherkin, BDD, Cucumber y TestNG.
🎯 Objetivo General
Automatizar un flujo E2E completo en OrangeHRM integrando todas las herramientas vistas en el curso: POO, Selenium, POM, Gherkin, BDD y Cucumber.
Flujo a automatizar: LOGIN ➔ DASHBOARD ➔ BUSCAR EMPLEADO ➔ LOGOUT
💻 Aplicación bajo prueba
URL de OrangeHRM Demo: https://opensource-demo.orangehrmlive.com/
Credenciales de prueba:
Usuario: Admin
Contraseña: admin123
(Estas son las credenciales indicadas para el entorno de prueba del proyecto).
🛠️ Tecnologías utilizadas
IntelliJ IDEA 2026.1.3 (Entorno de desarrollo)
Java JDK 25
Selenium WebDriver 4.10.0
Cucumber Java 7.13.0
Cucumber TestNG 7.13.0
TestNG 7.8.0
Maven
Gherkin
Page Object Model (POM)
BDD
Programación Orientada a Objetos (POO)
🏗️ Arquitectura del proyecto
El proyecto utiliza el patrón Page Object Model (POM) para separar la lógica de interacción con la aplicación de los escenarios de prueba.
Las principales clases Page Objects implementadas son:
BasePage
Contiene métodos reutilizables para interactuar con los elementos de la aplicación:
click
type
getText
isElementVisible
waitForUrlContains
waitForElementToDisappear
LoginPage
Gestiona las acciones relacionadas con el inicio de sesión:
Navegar a Login
Ingresar usuario y contraseña
Realizar login
Verificar página de Login y mensajes de error
DashboardPage
Gestiona las acciones del menú principal (Dashboard):
Navegar al módulo PIM
Realizar logout
Verificar Dashboard y obtener texto del encabezado
PIMPage
Gestiona la búsqueda de empleados:
Buscar empleado por nombre
Verificar resultados o mensaje de ausencia de resultados
Verificar página PIM
Estas clases y métodos forman parte de los requerimientos definidos para el proyecto.
🥒 BDD y Gherkin
Los escenarios de prueba se encuentran definidos mediante Gherkin, utilizando Cucumber. El archivo principal es flujo_completo.feature, el cual contiene tres escenarios:
Scenario 1 — Login exitoso: Validación del inicio de sesión utilizando credenciales válidas.
Scenario 2 — Buscar empleado: Flujo: Login ➔ Navegar a PIM ➔ Buscar empleado.
Scenario 3 — Flujo completo E2E: Flujo completo: Login ➔ Buscar empleado ➔ Logout.
Los tres escenarios forman parte de los requerimientos de la entrega.
🧩 Step Definitions y Runner
Hooks.java: Se utiliza para gestionar el ciclo de vida del WebDriver mediante las anotaciones @Before y @After, permitiendo inicializar y cerrar el navegador antes y después de las pruebas.
FlujoPrincipalSteps.java: Contiene la implementación del código (steps) definidos en los escenarios Gherkin.
TestRunner.java: Contiene la configuración necesaria para ejecutar las pruebas de Cucumber mediante TestNG.
▶️ Ejecución del proyecto
Clonar el repositorio:
git clone https://github.com/joelfusaro/ProyectoIntegradorTestAutomation-Fusaro-.git


Ingresar al proyecto:
cd ProyectoIntegradorTestAutomation


Ejecutar las pruebas:
Utilizando Maven desde la terminal:
mvn test

También se puede ejecutar el archivo TestRunner directamente desde IntelliJ IDEA.
⏱️ Waits
OrangeHRM puede presentar tiempos de carga variables durante la ejecución de las pruebas. Por este motivo, se utilizan mecanismos de espera explícitos e implícitos para permitir que los elementos estén disponibles antes de interactuar con ellos. La consigna recomienda utilizar waits de aproximadamente 10 a 15 segundos cuando sea necesario.
👤 Datos de prueba
El empleado utilizado para las pruebas de búsqueda es: John
(La consigna indica que el empleado John existe en el sistema de pruebas).
✅ Criterios de cumplimiento
[x] Proyecto compila sin errores.
[x] Page Objects implementados con herencia.
[x] Feature file con 3 escenarios.
[x] Tests ejecutables correctamente.
📦 Entrega
El proyecto se entrega cumpliendo los siguientes parámetros:
Repositorio de GitHub público.
Archivo ZIP con el proyecto completo (excluyendo la carpeta target/).
Nombre del repositorio: ProyectoIntegradorTestAutomation[Fusaro]
Nombre del ZIP: ProyectoIntegradorQAA_ProyectoIntegradorTestAutomationl_[Fusaro].zip
👨‍💻 Autor: Joel Fusaro
