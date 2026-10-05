# Control de Despensa - API REST

## Descripción

Este proyecto consiste en una API REST desarrollada en Java con Spring Boot para consultar y analizar productos de una despensa. Los productos se manejan en memoria mediante una lista y se pueden consultar por ID, categoría, stock bajo y valor total.

## Tecnologías utilizadas

* Java 25
* Spring Boot
* Maven
* Spring Web
* IntelliJ IDEA

## Datos del proyecto

* **GroupId:** `com.estudiante`
* **ArtifactId:** `control-despensa-api`
* **Version:** `0.0.1-SNAPSHOT`
* **Tipo:** JAR

### ¿Qué significan?

* **GroupId:** identifica el grupo o paquete principal del proyecto.
* **ArtifactId:** identifica el nombre del proyecto.
* **Version:** indica la versión actual del proyecto.

## Estructura

```text
src/main/java
└── com.estudiante.despensa
    ├── ControlDespensaApiApplication.java
    ├── controller
    │   └── ProductoController.java
    └── model
        ├── Producto.java
        └── ResumenInventario.java
```

## Clases principales

### Producto

Representa los productos de la despensa. Contiene datos como ID, nombre, categoría, cantidad y precio unitario. También calcula el subtotal de cada producto.

### ResumenInventario

Contiene el resumen general del inventario: cantidad de productos, total de unidades y valor total.

### ProductoController

Contiene los endpoints de la API para consultar los productos y generar los diferentes análisis.

## Endpoints

| Método | Endpoint                               | Descripción                                      |
| ------ | -------------------------------------- | ------------------------------------------------ |
| GET    | `/api/productos`                       | Muestra todos los productos                      |
| GET    | `/api/productos/{id}`                  | Busca un producto por ID                         |
| GET    | `/api/productos/categoria/{categoria}` | Filtra productos por categoría                   |
| GET    | `/api/productos/stock-bajo`            | Muestra productos con cantidad menor o igual a 3 |
| GET    | `/api/productos/mayor-valor`           | Muestra el producto con mayor subtotal           |
| GET    | `/api/productos/resumen`               | Muestra el resumen del inventario                |

## Ejecución

Para ejecutar el proyecto:

1. Abrir el proyecto en IntelliJ IDEA.
2. Esperar a que Maven cargue las dependencias.
3. Ejecutar `ControlDespensaApiApplication.java`.
4. Abrir en el navegador:

```text
http://localhost:8080/api/productos
```

## Ejemplo de respuesta

```json
[
  {
    "id": 1,
    "nombre": "Arroz",
    "categoria": "Granos",
    "cantidad": 4,
    "precioUnitario": 8.5
  }
]
```

### Resumen del inventario

```json
{
  "cantidadProductos": 6,
  "totalUnidades": 22,
  "valorTotal": 244.5
}
```

## Datos del estudiante

* **Nombre:** Iván Eduardo del Cid Véliz
* **Carné/ID:** 9941-25-20822
