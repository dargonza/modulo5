# Instrucciones para ejecutar la aplicación en IntelliJ

## Requisitos previos
- IntelliJ IDEA instalado
- Docker y Docker Compose instalados
- Java 21 (JDK)
- Apache Tomcat 11
- Maven

## Pasos para ejecutar

1. Abrir el proyecto en IntelliJ IDEA:
- File -> Open -> Seleccionar la carpeta del proyecto

2. Configurar JDK en IntelliJ:
- File -> Project Structure -> Project
- Seleccionar Java 21 como Project SDK
- Aplicar cambios

3. Configurar Tomcat en IntelliJ:
- File -> Settings -> Build, Execution, Deployment -> Application Servers
- Click en + y seleccionar Tomcat Server
- Especificar la ruta de instalación de Tomcat 11
- Aplicar cambios

4. Configurar Run Configuration:
- Run -> Edit Configurations
- Click en + y seleccionar Tomcat Server -> Local
- Nombrar la configuración (ej: "Tomcat 11")
- En la pestaña Deployment, click en + y seleccionar Artifact
- Seleccionar el archivo WAR del proyecto
- Aplicar cambios

5. Levantar la base de datos MySQL:
- Abrir una terminal en IntelliJ (Alt+F12)
- Navegar al directorio donde está el docker-compose.yml
- Ejecutar: docker-compose up -d
- El archivo init.sql se ejecutará automáticamente creando las tablas e insertando datos iniciales

6. Verificar que Maven está configurado:
- View -> Tool Windows -> Maven
- Refrescar el proyecto Maven si es necesario
- Ejecutar: mvn clean install

7. Ejecutar la aplicación:
- Click en el botón Run (triángulo verde) y seleccionar la configuración de Tomcat
- O usar el atajo Shift+F10

8. Acceder a la aplicación:
http://localhost:8080/

