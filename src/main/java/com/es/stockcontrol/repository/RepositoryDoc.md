### Ayuda para implementar Repository

# Documentación

En este paquete recordad que debéis implementar las clases que acceden a la base de datos.

En este caso, tenemos una base de datos MySQL gestionada por Hibernate.

En esta base de datos tenemos 3 tablas:
1. Tabla Proveedores
2. Tabla Productos
3. Tabla Usuarios

Hay que crear al menos 3 clases Repository, una por cada Entidad que queremos manejar de la base de datos.


# Explicación sobre las capas: Repository

En una arquitectura basada en servicios, las capas de **Controller**, **Service**, y **Repository** están diseñadas para mantener una separación de preocupaciones, lo que facilita la mantenibilidad y escalabilidad del código.


## Repository:
El **Repository** abstrae la capa de persistencia de datos, proporcionando una interfaz clara para las operaciones CRUD (Create, Read, Update, Delete). Está aislado de la lógica de negocio y su responsabilidad es única: interactuar directamente con la base de datos. Usualmente, el **Repository** sigue un patrón DAO (Data Access Object) para gestionar el acceso a los datos de manera limpia y eficiente.

- **Responsabilidades**:
    - Ejecutar operaciones CRUD.
    - Abstraer las consultas a la base de datos.
    - Proveer métodos específicos para recuperar o modificar datos.

## Relación Compleja entre las Capas:
1. El **Controller** recibe la solicitud del cliente (por ejemplo, un POST de creación de usuario).
2. Pasa los datos a la capa **Service**, que aplica las reglas de negocio, como verificar si el usuario ya existe.
3. La capa **Service** interactúa con el **Repository** para realizar operaciones sobre la base de datos, como almacenar el nuevo usuario.
4. El **Repository** realiza las consultas directas a la base de datos y devuelve el resultado a la capa **Service**.
5. El **Service** procesa el resultado y lo devuelve al **Controller** para que éste genere la respuesta apropiada para el cliente.

Este modelo promueve el **desacoplamiento** y facilita la **pruebas unitarias** al permitir testear cada capa de manera independiente.
