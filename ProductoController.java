package com.estudiante.despensa.controller;

import com.estudiante.despensa.model.Producto;
import com.estudiante.despensa.model.ResumenInventario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final List<Producto> productos = new ArrayList<>();

    public ProductoController() {
        productos.add(new Producto(1L, "Arroz", "Granos", 4, 8.50));
        productos.add(new Producto(2L, "Leche", "Lácteos", 2, 12.00));
        productos.add(new Producto(3L, "Frijol", "Granos", 6, 9.00));
        productos.add(new Producto(4L, "Jabón", "Limpieza", 3, 7.50));
        productos.add(new Producto(5L, "Gaseosa", "Bebidas", 2, 10.00));
        productos.add(new Producto(6L, "Queso", "Lácteos", 5, 18.00));
    }

    @GetMapping
    public List<Producto> obtenerProductos() {
        return productos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {

        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return ResponseEntity.ok(producto);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/categoria/{categoria}")
    public List<Producto> buscarPorCategoria(@PathVariable String categoria) {

        List<Producto> resultado = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(producto);
            }
        }

        return resultado;
    }

    @GetMapping("/stock-bajo")
    public List<Producto> obtenerStockBajo() {

        List<Producto> resultado = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCantidad() <= 3) {
                resultado.add(producto);
            }
        }

        return resultado;
    }

    @GetMapping("/mayor-valor")
    public ResponseEntity<Producto> obtenerMayorValor() {

        if (productos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Producto mayor = productos.get(0);

        for (Producto producto : productos) {
            if (producto.calcularSubtotal() > mayor.calcularSubtotal()) {
                mayor = producto;
            }
        }

        return ResponseEntity.ok(mayor);
    }

    @GetMapping("/resumen")
    public ResumenInventario obtenerResumen() {

        int cantidadProductos = productos.size();
        int totalUnidades = 0;
        double valorTotal = 0;

        for (Producto producto : productos) {
            totalUnidades += producto.getCantidad();
            valorTotal += producto.calcularSubtotal();
        }

        return new ResumenInventario(
                cantidadProductos,
                totalUnidades,
                valorTotal
        );
    }
}