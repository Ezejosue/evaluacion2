# Evaluacion2

Este proyecto es una aplicación de gestión de productos y pedidos desarrollada con Java y Spring Boot. Utiliza Maven como herramienta de construcción y gestión de dependencias.

## Características

- **Lenguaje**: Java
- **Framework**: Spring Boot
- **Gestión de dependencias**: Maven
- **Base de datos**: JPA con Hibernate

## Estructura del Proyecto

- `src/main/java/com/orm/evaluacion2/controllers`: Contiene los controladores REST para manejar las solicitudes HTTP.
- `src/main/java/com/orm/evaluacion2/entities`: Contiene las entidades JPA que representan las tablas de la base de datos.
- `src/main/java/com/orm/evaluacion2/services`: Contiene las clases de servicio que implementan la lógica de negocio.
- `src/main/java/com/orm/evaluacion2/dtos`: Contiene las clases DTO (Data Transfer Object) utilizadas para transferir datos entre las capas de la aplicación.
- `src/main/resources`: Contiene los archivos de configuración y otros recursos estáticos.

## Requisitos

- Java 11 o superior
- Maven 3.6.0 o superior

## Instalación

1. Clonar el repositorio:
   ```sh
   git clone https://github.com/usuario/evaluacion2.git
   ```
2. Navegar al directorio del proyecto:
   ```sh
   cd evaluacion2
   ```
3. Construir el proyecto con Maven:
   ```sh
   mvn clean install
   ```

## Ejecución

Para ejecutar la aplicación, usar el siguiente comando:
```sh
mvn spring-boot:run
```

## Documentación

La documentación de la API está disponible en el siguiente enlace:
[Swagger UI](http://localhost:8080/swagger-ui/index.html#/)

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o un pull request para discutir cualquier cambio que desees realizar.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

## Creado por

- Josue Avalos 
