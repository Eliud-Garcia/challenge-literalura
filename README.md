# 📚 Literalura

Aplicación de consola desarrollada en Java con Spring Boot para consultar libros y autores usando la API de Gutendex y una base de datos para almacenar las respuestas de la API.

---

## 🚀 Tecnologías

Este proyecto fue construido usando:

- ☕ Java 17+
- 🌱 Spring Boot
- 🗄️ Spring Data JPA
- 🐘 PostgreSQL
- 📦 Maven
- 🔗 [API Gutendex](https://gutendex.com)
- 🔄 Jackson (jackson-databind)

---

# ⚙️ Configuración del Proyecto

Este documento describe cómo configurar el entorno necesario para ejecutar el proyecto correctamente.

---

## 🌱 Variables de entorno

El proyecto utiliza variables de entorno para manejar configuraciones sensibles.

### Variables requeridas

Reemplaza los valores de las variables en el archivo **application.properties**
```env
spring.datasource.url=jdbc:postgresql://DB_HOST/DB_NAME
spring.datasource.username=DB_POSTGRESQL_USER
spring.datasource.password=DB_POSTGRESQL_PASSWORD

