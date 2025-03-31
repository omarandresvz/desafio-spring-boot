# Desafío Técnico - Gestión de Tareas

Este proyecto es una API REST desarrollada en **Java 17** y **Spring Boot 3.4.x** que permite la gestión de tareas y usuarios con autenticación mediante JWT.

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3.4.3**
- **Spring Security con JWT**
- **Base de datos H2** (en memoria)
- **Swagger y OpenAPI** para documentación
- **Maven** para la gestión de dependencias

---

## Requisitos previos
Antes de ejecutar la aplicación, asegúrate de tener instalados:
- **Java 17**
- **Maven**
- **Postman** (opcional, para pruebas)

---

## Instalación y Ejecución
Ejecuta el siguiente comando en la raíz del proyecto:

mvn spring-boot:run

Esto iniciará la aplicación en http://localhost:8080

---

## Acceder a la API
**Swagger UI:**  [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

**Documentación OpenAPI:**  [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

**Base de datos H2:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  

Credenciales de H2:
- **URL:** jdbc:h2:mem:testdb
- **Usuario:** sa
- **Contraseña:** (vacía)

---

## Autenticación y Seguridad
Esta API usa **JWT (JSON Web Token)** para la autenticación.

 **Iniciar sesión:**
   - Realiza un POST /api/auth/login enviando un JSON con las credenciales.
   - Recibirás un token JWT.

 **Usar el token en todas las eticiones:**
    

---

## ️ Endpoints Disponibles

###  Autenticación
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /api/auth/login | Iniciar sesión y obtener token JWT |

###  Usuarios
| Método | Endpoint | Descripción |
|--------|----------|----------------------|
| POST | /users/create | Crear un nuevo usuario |

###  Tareas
| Método | Endpoint | Descripción |
|---------|--------------------|----------------------|
| POST | /tasks/create | Crear una nueva tarea |
| GET | /tasks/list-tasks | Listar todas las tareas |
| GET | /tasks/{id} | Obtener una tarea por ID |
| PUT | /tasks/update-task/{id} | Actualizar una tarea |
| DELETE | /tasks/delete-task/{id} | Eliminar una tarea |

---

Pruebas con Postman
**Colección Postman adjunta:**

Importa el archivo desafio-postman-collection.json en Postman para realizar pruebas.

 **Login (POST /api/auth/login)**  
   - Usa un usuario válido para obtener un token JWT (este ya viene agregado en el archivo).

 **Configurar el token en Postman:**  
   - Copia el token y agrégalo en Authorization: Token <tu_token> (al ejecutar el login se agrega el token en las demás peticiones)