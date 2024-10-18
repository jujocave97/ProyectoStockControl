### Ayuda para implementar Controller

# Documentación

<h3>Explicación de métodos para la gestión de productos</h3>

<ol>
<li><p><strong>altaProducto</strong>:
Este método está diseñado para registrar un nuevo producto. Los parámetros incluyen detalles sobre el producto (como su ID, nombre, precio sin IVA, descripción) y sobre el proveedor (ID, nombre, dirección). La respuesta de este método debería reflejar si la operación de alta fue exitosa o no.</p>

<ul>
<li>Parámetros:
<ul>
<li><code>idProducto</code>: Identificador único del producto.</li>
<li><code>nombreProducto</code>: Nombre del producto.</li>
<li><code>precioSinIva</code>: Precio del producto sin incluir el IVA.</li>
<li><code>descripcionProducto</code>: Descripción del producto.</li>
<li><code>idProveedor</code>: Identificador único del proveedor.</li>
<li><code>nombreProveedor</code>: Nombre del proveedor.</li>
<li><code>direccionProveedor</code>: Dirección del proveedor.</li>
</ul></li>
</ul></li>
<li><p><strong>bajaProducto</strong>:
Este método realiza la baja (eliminación) de un producto, dada su ID. La respuesta debería contener el resultado de la operación, es decir, si el producto fue eliminado exitosamente o si ocurrió algún error.</p>

<ul>
<li>Parámetro:
<ul>
<li><code>id</code>: Identificador del producto a eliminar.</li>
</ul></li>
</ul></li>
<li><p><strong>modificarNombreProducto</strong>:
Este método permite modificar el nombre de un producto existente. Se requiere el ID del producto para identificarlo y el nuevo nombre que se le asignará. La respuesta debería reflejar el éxito o fallo de la modificación.</p>

<ul>
<li>Parámetros:
<ul>
<li><code>id</code>: Identificador del producto cuyo nombre se desea cambiar.</li>
<li><code>nuevoNombre</code>: Nuevo nombre que se asignará al producto.</li>
</ul></li>
</ul></li>
<li><p><strong>modificarStockProducto</strong>:
Permite modificar la cantidad de stock de un producto específico. El método recibe el ID del producto y el nuevo valor del stock. La respuesta indicará si la actualización fue exitosa.</p>

<ul>
<li>Parámetros:
<ul>
<li><code>id</code>: Identificador del producto cuyo stock será modificado.</li>
<li><code>nuevoStock</code>: Nuevo valor del stock del producto.</li>
</ul></li>
</ul></li>
<li><p><strong>getProducto</strong>:
Este método busca y devuelve la información de un producto en particular, identificado por su ID. La respuesta contendrá los detalles del producto si la búsqueda fue exitosa.</p>

<ul>
<li>Parámetro:
<ul>
<li><code>id</code>: Identificador del producto a obtener.</li>
</ul></li>
</ul></li>
<li><p><strong>getProductosConStock</strong>:
Este método busca y devuelve una lista de todos los productos que tienen stock disponible. La respuesta incluirá una lista de productos con stock mayor a cero.</p></li>
<li><p><strong>getProductosSinStock</strong>:
Este método devuelve una lista de productos que no tienen stock disponible (su stock es igual a cero). La respuesta incluirá una lista de productos que están agotados. </p></li>
</ol>

<h3>Resumen</h3>

<p>Cada uno de estos métodos implementa una funcionalidad específica sobre productos (alta, baja, modificación, consulta) y devuelve una respuesta que incluirá un código de estado, mensaje, y los datos correspondientes al producto o lista de productos, dependiendo del caso. Esto está alineado con las prácticas comunes en aplicaciones RESTful, donde las operaciones CRUD se realizan a través de HTTP y se encapsulan en respuestas estándar.</p>

<h3>Explicación de métodos para la gestión de proveedores</h3>

<ol>
<li><p><strong>getProveedoresProducto</strong>:
Este método está diseñado para obtener una lista de proveedores asociados a un producto específico, identificado por su ID. El método devuelve una lista de proveedores que suministran dicho producto. La respuesta debe incluir la lista de proveedores si la operación fue exitosa.</p>

<ul>
<li>Parámetro:
<ul>
<li><code>idProducto</code>: Identificador del producto del cual se desean obtener los proveedores.</li>
</ul></li>
</ul></li>
<li><p><strong>getTodosProveedores</strong>:
Este método devuelve una lista de todos los proveedores registrados en el sistema. No requiere parámetros y su resultado será la lista completa de proveedores disponibles. La respuesta debe reflejar si la operación fue exitosa y contener los datos de los proveedores.</p></li>
</ol>

<h3>Resumen</h3>

<p>Ambos métodos están enfocados en la obtención de datos sobre proveedores. El primero está restringido a los proveedores de un producto específico, mientras que el segundo ofrece una lista de todos los proveedores del sistema. Ambos retornan una respuesta HTTP que contendrá los datos y el estado de la operación.</p>

<h3>Explicación del método para iniciar sesión</h3>

<p><strong>login</strong>:
Este método se utiliza para autenticar a un usuario. Recibe como parámetros el nombre de usuario o identificación (<code>userInput</code>) y la contraseña (<code>passInput</code>). El objetivo del método es validar las credenciales ingresadas por el usuario y, si son correctas, devolver una respuesta HTTP con la información del usuario autenticado.</p>

<ul>
<li>Parámetros:
<ul>
<li><code>userInput</code>: Identificador del usuario (puede ser el nombre de usuario, correo electrónico u otro identificador).</li>
<li><code>passInput</code>: Contraseña del usuario para autenticación.</li>
</ul></li>
</ul>

<p>La respuesta del método debe contener el resultado de la autenticación: si el usuario ha iniciado sesión correctamente, se devolverá la información correspondiente al usuario; de lo contrario, se indicará un fallo en la autenticación.</p>

<h3>Resumen</h3>

<p>Este método maneja la autenticación de usuarios, verificando sus credenciales y devolviendo la información del usuario autenticado en caso de éxito, o un mensaje de error si las credenciales no son válidas.</p>


# Explicación sobre las capas: Controller, Service y Repository

En una arquitectura basada en servicios, las capas de **Controller**, **Service**, y **Repository** están diseñadas para mantener una separación de preocupaciones, lo que facilita la mantenibilidad y escalabilidad del código.

## Controller:
El **Controller** es la capa responsable de recibir y manejar las solicitudes HTTP. Su función principal es la de orquestador: recibe los datos, los valida y delega la lógica de negocio a la capa de servicios. Después, recopila el resultado del **Service** y lo envía como respuesta al cliente. Es el punto de entrada para las interacciones con el usuario o API.

- **Responsabilidades**:
    - Recibir y procesar solicitudes HTTP.
    - Validar y transformar los datos de entrada.
    - Delegar la ejecución de lógica de negocio a la capa de **Service**.



## Relación Compleja entre las Capas:
1. El **Controller** recibe la solicitud del cliente (por ejemplo, un POST de creación de usuario).
2. Pasa los datos a la capa **Service**, que aplica las reglas de negocio, como verificar si el usuario ya existe.
3. La capa **Service** interactúa con el **Repository** para realizar operaciones sobre la base de datos, como almacenar el nuevo usuario.
4. El **Repository** realiza las consultas directas a la base de datos y devuelve el resultado a la capa **Service**.
5. El **Service** procesa el resultado y lo devuelve al **Controller** para que éste genere la respuesta apropiada para el cliente.

Este modelo promueve el **desacoplamiento** y facilita la **pruebas unitarias** al permitir testear cada capa de manera independiente.
