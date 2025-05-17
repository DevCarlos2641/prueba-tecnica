# 📝 Reto Técnico para la Vacante de Becario

Este proyecto es una API REST desarrollada con Spring Boot y MySQL que permite gestionar tareas tipo "ToDo". Puedes ejecutarla localmente y probar sus funcionalidades mediante Swagger UI.

---

## ✅ Requisitos

- Tener **MySQL** instalado y corriendo en el puerto `3306`.
- Tener **Java 17** y **Gradle** (o usar el wrapper `./gradlew`).
- Tener una herramienta como Postman o simplemente usar **Swagger UI** para probar los endpoints.

---

## 🚀 Ejecución local

1. Clona el repositorio:

```bash
git clone https://github.com/DevCarlos2641/prueba-tecnica.git
cd prueba-tecnica
```

2. Asegúrate de tener MySQL corriendo. No necesitas crear la base de datos manualmente, ya que Spring Boot se encargará de ello automáticamente al ejecutar la app.

3. Ejecuta la aplicación de Spring Boot desde tu IDE o terminal:

```bash
./gradlew bootRun
ó
gradlew bootRun
```

---

## 📄 Endpoints disponibles

Puedes interactuar con la API usando Swagger en:

🔗 [http://localhost:8080/reto-tecnico/api/v1/swagger-ui/index.html](http://localhost:8080/reto-tecnico/api/v1/swagger-ui/index.html)

---

## 📬 Pruebas de la API

### 1. Crear un nuevo ToDo

- **Método:** `POST`  
- **URL:** `/reto-tecnico/api/v1/todo`  
- **Body:**

```json
{
  "description": "description 1",
  "date": "2025-04-16",
  "status": "en progreso"
}
```

---

### 2. Obtener todos los ToDos

- **Método:** `GET`  
- **URL:** `/reto-tecnico/api/v1/todo`

---

### 3. Actualizar información de un ToDo

- **Método:** `PUT`  
- **URL:** `/reto-tecnico/api/v1/todo/{id}`  
- **Body:**

```json
{
  "description": "Otra descripcion",
  "date": "2025-04-17",
  "status": "finalizado"
}
```

---

### 4. Cambiar solo el estado de un ToDo

- **Método:** `PATCH`  
- **URL:** `/reto-tecnico/api/v1/todo/{id}`  
- **Body:**

```json
{
  "status": "pendiente"
}
```

---

### 5. Eliminar un ToDo por ID

- **Método:** `DELETE`  
- **URL:** `/reto-tecnico/api/v1/todo/{id}`

---

## 🧾 Notas adicionales

- La base de datos y tabla se crean automáticamente al ejecutar la aplicación.

---

> Desarrollado por Carlos Iván  
> [GitHub](https://github.com/DevCarlos2641)
