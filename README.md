# Reto técnico para la vacante de becario

## Requisitos
-  Mysql instalado

## 🛠️ Configuración

1. Clona este repositorio:


    git clone https://github.com/DevCarlos2641/PruebaTecnica.git
    cd PruebaTecnica

2. Si ya tiene instalado mysql en el puerto 3306, solamente ejecute la app de Spring boot, la base de datos se crea automáticamente así como la tabla

## Pruebas

Con la ayuda de Swagger puede interarctuar mas facilmente entre los EndPoints

http://localhost:8080/reto-tecnico/api/v1/swagger-ui/index.html

1.	Crear un nuevo ToDo (POST)

    Method: POST
    url: localhost:8080/reto-tecnico/api/v1/todo
    body: {
        "description": "description 1",
        "date": "2025-04-16",
        "status": "en progreso"
    }

2.	Obtener todos los ToDos (GET)

    Method: GET
    url: localhost:8080/reto-tecnico/api/v1/todo

3.	Actualizar la información de un ToDo (PUT)

    Method: PUT
    Parametros: id
    url: localhost:8080/reto-tecnico/api/v1/todo/id
    body:{
        "description": "Otra descripcion",
        "date": "2025-04-17",
        "status": "finalizado"
    }

4.	Cambiar únicamente el estatus de un ToDo (PATCH)

    Method: PATCH
    Parametros: id
    url: localhost:8080/reto-tecnico/api/v1/todo/id
    body: {
        "status": "pendiente"
    }

5.	Eliminar un ToDo por ID (DELETE)
    
    Method: DELETE
    parametros: id
    url: localhost:8080/reto-tecnico/api/v1/todo/id