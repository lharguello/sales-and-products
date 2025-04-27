# 🛒 API Restful de Productos y Ventas

Este proyecto es una API RESTful desarrollada con **Spring Boot 3** y **Java 21** para gestionar productos y ventas.  
Incluye seguridad basada en **API Key**, documentación **Swagger**, base de datos en memoria **H2**, uso de **DTOs** para los datos expuestos y persistidos, y mapeo automático mediante **MapStruct**.

---

## 🚀 Tecnologías utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Spring Security (API Key Authentication)
- H2 Database
- Swagger OpenAPI (springdoc-openapi)
- MapStruct
- Lombok
- Maven

---

## 🛠 Instalación y Ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/lharguello/sales-and-products.git
   ```
   
2. Acceder a la carpeta del proyecto:
   ```bash
   cd sales-and-products
   ```

3. Construir el proyecto con Maven:
   ```bash
   mvn clean install
   ```

4. Ejecutar la aplicación:
   ```bash
   mvn spring-boot:run
   ```

La API estará disponible en:  
`http://localhost:8080`

---

## 🔑 Seguridad API Key

Todos los endpoints están protegidos por API Key.  
Debes enviar en cada request el header:

| Header        | Valor                                      |
|---------------|--------------------------------------------|
| `x-api-key`   | `a1b2c3d4-e5f6-7890-1234-567890abcdef`      |

---

## 📚 Documentación Swagger

Accede a la documentación interactiva de la API aquí:  
👉 [`http://localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)

---

## 💾 Base de Datos H2

Consola de administración H2 disponible en:  
👉 [`http://localhost:8080/h2-ui`](http://localhost:8080/h2-ui)

**Credenciales:**
- Usuario: `sa`
- Contraseña: *(vacía)*

---

## 🧩 Estructura del Proyecto

```plaintext
src/main/java/com/sales/apirest/
├── config/                  # Configuraciones generales (Swagger, etc.)
├── controller/               # Controladores REST para Productos y Ventas
├── exception/                # Manejo global de excepciones y errores personalizados
├── mapper/                   # Interfaces MapStruct para mapear Entidades a DTOs
├── model/
│   ├── dto/                  # Definición de DTOs para request y response
│   └── entity/               # Entidades JPA (Product y Sale)
├── repository/               # Interfaces JPA Repositories
├── security/
│   ├── config/               # Configuración de seguridad API Key
│   └── filter/               # Filtro personalizado para validar API Key
├── service/                  # Servicios de negocio (productos y ventas)
└── ApiRestApplication.java   # Clase principal para iniciar Spring Boot
```

---

## 📥 Scripts de Precarga de Datos

La aplicación precarga automáticamente datos iniciales mediante dos archivos:

- `schema.sql` ➔ Crea las tablas `products` y `sales`.

- `data.sql` ➔ Inserta registros de productos y ventas con fechas recientes.

Ambos archivos se encuentran en `src/main/resources/`.
Spring Boot ejecuta `schema.sql` antes de `data.sql` al iniciar la aplicación.

---

## 🧪 Ejecución de Pruebas

Para probar la API puedes usar herramientas como:
- Postman
- cURL
- Swagger UI directamente

**Importante:** recuerda siempre enviar el header `x-api-key`.