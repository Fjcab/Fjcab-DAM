package com.example.restauranteApi.controller;

import com.example.restauranteApi.dto.ProductoDTO;
import com.example.restauranteApi.mapper.ProductoMapper;
import com.example.restauranteApi.model.Producto;
import com.example.restauranteApi.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    /*
    GET:
        Buscar todos
        Buscar por ID
        Buscar por nombre
        Buscar por categoría
     */

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> obtenerTodosLosProductos() {
        List<Producto> productos = productoService.findAll();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        List<ProductoDTO> productosDTO = productos.stream()
                .map(ProductoMapper::toProductoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productosDTO); // 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Producto no encontrado con ID: " + id);
        }
        return ResponseEntity.ok(ProductoMapper.toProductoDTO(producto)); // 200 OK
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ProductoDTO>> obtenerProductosPorNombre(@PathVariable String nombre) {
        List<Producto> productos = productoService.findByNombreContainingIgnoreCase(nombre);
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        List<ProductoDTO> productosDTO = productos.stream()
                .map(ProductoMapper::toProductoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productosDTO); // 200 OK
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProductoDTO>> obtenerProductosPorCategoria(@PathVariable String categoria) {
        List<Producto> productos = productoService.findByCategoria(categoria);
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        List<ProductoDTO> productosDTO = productos.stream()
                .map(ProductoMapper::toProductoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productosDTO); // 200 OK
    }

    /*
    POST:
        Agregar producto JSON
        Agregar producto form-data
     */

    @PostMapping
    public ResponseEntity<?> agregarProductoJson(@RequestBody Producto producto) {
        try {
            Producto nuevoProducto = productoService.save(producto);
            ProductoDTO productoDTO = ProductoMapper.toProductoDTO(nuevoProducto);
            return ResponseEntity.ok(productoDTO); // 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear producto: " + e.getMessage());
        }
    }

    @PostMapping("/form")
    public ResponseEntity<?> agregarProductoForm(
            @RequestParam("nombre") String nombre,
            @RequestParam(value = "descripcion", required = false) String descripcion,
            @RequestParam("precio") Double precio,
            @RequestParam(value = "categoria", required = false) String categoria) {
        try {
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(BigDecimal.valueOf(precio));
            producto.setCategoria(categoria);

            Producto nuevoProducto = productoService.save(producto);
            ProductoDTO productoDTO = ProductoMapper.toProductoDTO(nuevoProducto);

            return ResponseEntity.ok(productoDTO); // 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear producto: " + e.getMessage());
        }
    }

    /*
    PUT:
        Actualizar producto por ID
        Actualizar producto por nombre
     */

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProductoPorId(@PathVariable Long id, @RequestBody Producto producto) {
        try {
            producto.setId(id);
            Producto actualizado = productoService.save(producto);
            ProductoDTO productoDTO = ProductoMapper.toProductoDTO(actualizado);
            return ResponseEntity.ok(productoDTO); // 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar producto: " + e.getMessage());
        }
    }

    @PutMapping("/nombre/{nombre}")
    public ResponseEntity<?> actualizarProductoPorNombre(@PathVariable String nombre, @RequestBody Producto producto) {
        try {
            Producto actualizado = productoService.updateByNombre(nombre, producto);
            if (actualizado == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Producto no encontrado con nombre: " + nombre);
            }
            ProductoDTO productoDTO = ProductoMapper.toProductoDTO(actualizado);
            return ResponseEntity.ok(productoDTO); // 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar producto: " + e.getMessage());
        }
    }

    /*
    DELETE:
        Eliminar producto por ID
        Eliminar producto por nombre
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProductoPorId(@PathVariable Long id) {
        try {
            productoService.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al eliminar producto: " + e.getMessage());
        }
    }

    @DeleteMapping("/nombre/{nombre}")
    public ResponseEntity<?> eliminarProductoPorNombre(@PathVariable String nombre) {
        try {
            productoService.deleteByNombre(nombre);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al eliminar producto: " + e.getMessage());
        }
    }
}
