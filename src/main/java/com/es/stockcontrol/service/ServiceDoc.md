### Ayuda para implementar Repository

# Documentación

La lógica de negocio para cada Entidad es la siguiente:

1. Proveedor
- nombre: único, longitud 50, not null
- direccion: not null


2. Producto
- id: El id se compone por: 3 primeras letras de categoria + 3 primeras letras de nombre + 3 primeras letras de proveedor
- categoria: longitud 50, not null
- nombre: longitud 50, not null
- precio_sin_iva: not null
- precio_con_iva: not null. Calcular el precio aplicando el IVA sobre el precio sin iva
- fecha_alta: fecha de hoy


# Explicación sobre las capas: Service

En una arquitectura basada en servicios, las capas de **Controller**, **Service**, y **Repository** están diseñadas para mantener una separación de preocupaciones, lo que facilita la mantenibilidad y escalabilidad del código.


## Service:
La capa de **Service** encapsula la **lógica de negocio** de la aplicación. Es el puente entre los controladores y los repositorios, asegurando que todas las reglas de negocio y procesos complejos se gestionen de manera centralizada y coherente. Además, esta capa promueve la reutilización de código, ya que la lógica puede ser usada por diferentes controladores.

- **Responsabilidades**:
    - Implementar la lógica de negocio.
    - Interactuar con el **Repository** para gestionar el acceso a los datos.
    - Realizar validaciones y operaciones que van más allá de un simple CRUD.


## Relación Compleja entre las Capas:
1. El **Controller** recibe la solicitud del cliente (por ejemplo, un POST de creación de usuario).
2. Pasa los datos a la capa **Service**, que aplica las reglas de negocio, como verificar si el usuario ya existe.
3. La capa **Service** interactúa con el **Repository** para realizar operaciones sobre la base de datos, como almacenar el nuevo usuario.
4. El **Repository** realiza las consultas directas a la base de datos y devuelve el resultado a la capa **Service**.
5. El **Service** procesa el resultado y lo devuelve al **Controller** para que éste genere la respuesta apropiada para el cliente.

Este modelo promueve el **desacoplamiento** y facilita la **pruebas unitarias** al permitir testear cada capa de manera independiente.
