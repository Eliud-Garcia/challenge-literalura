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
## Base de datos

Crea la base de datos para usarla en el proyecto, **lo recomendado es crear una vacía** y con el nombre de literalura, este nombre lo debes de indicar en el application.properties.

## 🌱 Variables de entorno

El proyecto utiliza variables de entorno para manejar configuraciones sensibles.

### Variables requeridas

Reemplaza los valores de las variables en el archivo **application.properties**
```env
spring.datasource.url=jdbc:postgresql://DB_HOST/DB_NAME
spring.datasource.username=DB_POSTGRESQL_USER
spring.datasource.password=DB_POSTGRESQL_PASSWORD
```
<p align="center">
  <img src="./docs/Badge-Literalura.png" alt="Logo del proyecto" width="200"/>
</p>

