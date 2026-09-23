# Task University

Aplicacion web para la gestion de tareas academicas, desarrollada como Trabajo Practico Calificado del curso de Control de Versiones en la Nube.

## Integrantes

- Giovana
- Angela
- Diana
- Jose

## Tecnologias

- Java 17
- Spring Boot 3
- Spring Data JPA
- Thymeleaf
- MySQL

## Modulos

- **Tareas**: registrar, editar, eliminar y marcar tareas como completadas.
- **Usuarios**: registrar usuarios y ver el listado.
- **Dashboard**: total de tareas, completadas y pendientes.

## Configuracion local

1. Crear una base de datos MySQL llamada `task_university` (o dejar que se cree sola con `createDatabaseIfNotExist=true`).
2. Editar `src/main/resources/application.properties` con tu usuario y contraseña de MySQL.
3. Ejecutar:

   ```bash
   mvn spring-boot:run
   ```

4. Abrir `http://localhost:8080`.

## Flujo de ramas

- `main`: version estable.
- `develop`: integracion de features.
- `feature-usuarios`, `feature-tareas`, `feature-dashboard`: desarrollo por modulo.
