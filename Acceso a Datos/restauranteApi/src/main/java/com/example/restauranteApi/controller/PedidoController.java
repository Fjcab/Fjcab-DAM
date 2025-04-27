package com.example.restauranteApi.controller;

import com.example.restauranteApi.dto.PedidoDTO;
import com.example.restauranteApi.mapper.PedidoMapper;
import com.example.restauranteApi.model.Pedido;
import com.example.restauranteApi.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    /*
    GET:
        Buscar todos
        Buscar por ID
        Buscar por precio total
        Buscar por fecha
        Buscar por ID Cliente
        Buscar por ID Producto
     */
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll() {
        List<Pedido> pedidos = pedidoService.findAll();
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<PedidoDTO> pedidosDTO = pedidos.stream()
                .map(PedidoMapper::toPedidoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Pedido pedido = pedidoService.findById(id);
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido no encontrado con ID: " + id);
        }
        return ResponseEntity.ok(PedidoMapper.toPedidoDTO(pedido));
    }

    @GetMapping("/total")
    public ResponseEntity<List<PedidoDTO>> getByTotal(@RequestParam BigDecimal total) {
        List<Pedido> pedidos = pedidoService.findByTotalGreaterThanEqual(total);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<PedidoDTO> pedidosDTO = pedidos.stream()
                .map(PedidoMapper::toPedidoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidosDTO);
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<PedidoDTO>> getByFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha) {
        List<Pedido> pedidos = pedidoService.findByFecha(fecha);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<PedidoDTO> pedidosDTO = pedidos.stream()
                .map(PedidoMapper::toPedidoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidosDTO);
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<PedidoDTO>> getByCliente(@RequestParam Long clienteId) {
        List<Pedido> pedidos = pedidoService.findByClienteId(clienteId);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<PedidoDTO> pedidosDTO = pedidos.stream()
                .map(PedidoMapper::toPedidoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidosDTO);
    }

    @GetMapping("/producto")
    public ResponseEntity<List<PedidoDTO>> getByProducto(@RequestParam Long productoId) {
        List<Pedido> pedidos = pedidoService.findByProductoId(productoId);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<PedidoDTO> pedidosDTO = pedidos.stream()
                .map(PedidoMapper::toPedidoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidosDTO);
    }

    @GetMapping("/fecha-total")
    public ResponseEntity<List<PedidoDTO>> getByFechaAndTotal(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
            @RequestParam BigDecimal total) {
        List<Pedido> pedidos = pedidoService.findByFechaAndTotal(fecha, total);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<PedidoDTO> pedidosDTO = pedidos.stream()
                .map(PedidoMapper::toPedidoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidosDTO);
    }

    /*
    POST:
        Consultas por filtros combinados (body JSON y form)
     */

    @PostMapping("/cliente-fecha")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteYFecha(@RequestBody Map<String, String> body) {
        Long clienteId = Long.valueOf(body.get("clienteId"));
        LocalDateTime fecha = LocalDateTime.parse(body.get("fecha"));
        List<Pedido> pedidos = pedidoService.findByClienteIdAndFecha(clienteId, fecha);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-fecha-form")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteYFechaForm(
            @RequestParam Long clienteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha) {
        List<Pedido> pedidos = pedidoService.findByClienteIdAndFecha(clienteId, fecha);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-total")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteYTotal(@RequestBody Map<String, String> body) {
        Long clienteId = Long.valueOf(body.get("clienteId"));
        BigDecimal total = new BigDecimal(body.get("total"));
        List<Pedido> pedidos = pedidoService.findByClienteIdAndTotal(clienteId, total);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-total-form")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteYTotalForm(
            @RequestParam Long clienteId,
            @RequestParam BigDecimal total) {
        List<Pedido> pedidos = pedidoService.findByClienteIdAndTotal(clienteId, total);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-fecha-total")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteFechaTotal(@RequestBody Map<String, String> body) {
        Long clienteId = Long.valueOf(body.get("clienteId"));
        LocalDateTime fecha = LocalDateTime.parse(body.get("fecha"));
        BigDecimal total = new BigDecimal(body.get("total"));
        List<Pedido> pedidos = pedidoService.findByClienteIdAndFechaAndTotal(clienteId, fecha, total);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-fecha-total-form")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteFechaTotalForm(
            @RequestParam Long clienteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
            @RequestParam BigDecimal total) {
        List<Pedido> pedidos = pedidoService.findByClienteIdAndFechaAndTotal(clienteId, fecha, total);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/producto-fecha")
    public ResponseEntity<List<PedidoDTO>> buscarPorProductoYFecha(@RequestBody Map<String, String> body) {
        Long productoId = Long.valueOf(body.get("productoId"));
        LocalDateTime fecha = LocalDateTime.parse(body.get("fecha"));
        List<Pedido> pedidos = pedidoService.findByProductoIdAndFecha(productoId, fecha);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/producto-fecha-form")
    public ResponseEntity<List<PedidoDTO>> buscarPorProductoYFechaForm(
            @RequestParam Long productoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha) {
        List<Pedido> pedidos = pedidoService.findByProductoIdAndFecha(productoId, fecha);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/producto-total")
    public ResponseEntity<List<PedidoDTO>> buscarPorProductoYTotal(@RequestBody Map<String, String> body) {
        Long productoId = Long.valueOf(body.get("productoId"));
        BigDecimal total = new BigDecimal(body.get("total"));
        List<Pedido> pedidos = pedidoService.findByProductoIdAndTotal(productoId, total);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/producto-total-form")
    public ResponseEntity<List<PedidoDTO>> buscarPorProductoYTotalForm(
            @RequestParam Long productoId,
            @RequestParam BigDecimal total) {
        List<Pedido> pedidos = pedidoService.findByProductoIdAndTotal(productoId, total);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/producto-fecha-total")
    public ResponseEntity<List<PedidoDTO>> buscarPorProductoFechaTotal(@RequestBody Map<String, String> body) {
        Long productoId = Long.valueOf(body.get("productoId"));
        LocalDateTime fecha = LocalDateTime.parse(body.get("fecha"));
        BigDecimal total = new BigDecimal(body.get("total"));
        List<Pedido> pedidos = pedidoService.findByProductoIdAndFechaAndTotal(productoId, fecha, total);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/producto-fecha-total-form")
    public ResponseEntity<List<PedidoDTO>> buscarPorProductoFechaTotalForm(
            @RequestParam Long productoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
            @RequestParam BigDecimal total) {
        List<Pedido> pedidos = pedidoService.findByProductoIdAndFechaAndTotal(productoId, fecha, total);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-producto")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteYProducto(@RequestBody Map<String, String> body) {
        Long clienteId = Long.valueOf(body.get("clienteId"));
        Long productoId = Long.valueOf(body.get("productoId"));
        List<Pedido> pedidos = pedidoService.findByClienteIdAndProductoId(clienteId, productoId);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-producto-form")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteYProductoForm(
            @RequestParam Long clienteId,
            @RequestParam Long productoId) {
        List<Pedido> pedidos = pedidoService.findByClienteIdAndProductoId(clienteId, productoId);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-producto-total")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteProductoTotal(@RequestBody Map<String, String> body) {
        Long clienteId = Long.valueOf(body.get("clienteId"));
        Long productoId = Long.valueOf(body.get("productoId"));
        BigDecimal total = new BigDecimal(body.get("total"));
        List<Pedido> pedidos = pedidoService.findByClienteIdAndProductoIdAndTotal(clienteId, productoId, total);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-producto-total-form")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteProductoTotalForm(
            @RequestParam Long clienteId,
            @RequestParam Long productoId,
            @RequestParam BigDecimal total) {
        List<Pedido> pedidos = pedidoService.findByClienteIdAndProductoIdAndTotal(clienteId, productoId, total);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-producto-fecha")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteProductoFecha(@RequestBody Map<String, String> body) {
        Long clienteId = Long.valueOf(body.get("clienteId"));
        Long productoId = Long.valueOf(body.get("productoId"));
        LocalDateTime fecha = LocalDateTime.parse(body.get("fecha"));
        List<Pedido> pedidos = pedidoService.findByClienteIdAndFechaAndProductoId(clienteId, fecha, productoId);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-producto-fecha-form")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteProductoFechaForm(
            @RequestParam Long clienteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
            @RequestParam Long productoId) {
        List<Pedido> pedidos = pedidoService.findByClienteIdAndFechaAndProductoId(clienteId, fecha, productoId);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-producto-fecha-total")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteProductoFechaTotal(@RequestBody Map<String, String> body) {
        Long clienteId = Long.valueOf(body.get("clienteId"));
        Long productoId = Long.valueOf(body.get("productoId"));
        LocalDateTime fecha = LocalDateTime.parse(body.get("fecha"));
        BigDecimal total = new BigDecimal(body.get("total"));
        List<Pedido> pedidos = pedidoService.findByClienteIdAndFechaAndProductoIdAndTotal(clienteId, fecha, productoId, total);
        return construirRespuestaListaPedidos(pedidos);
    }

    @PostMapping("/cliente-producto-fecha-total-form")
    public ResponseEntity<List<PedidoDTO>> buscarPorClienteProductoFechaTotalForm(
            @RequestParam Long clienteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
            @RequestParam Long productoId,
            @RequestParam BigDecimal total) {
        List<Pedido> pedidos = pedidoService.findByClienteIdAndFechaAndProductoIdAndTotal(clienteId, fecha, productoId, total);
        return construirRespuestaListaPedidos(pedidos);
    }

    /*
    POST:
        Crear pedido
    */

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Pedido pedido) {
        try {
            Pedido nuevo = pedidoService.save(pedido);
            PedidoDTO dto = PedidoMapper.toPedidoDTO(nuevo);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear pedido: " + e.getMessage());
        }
    }


    /*
    PUT:
        Actualizar pedido por ID
    */

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Pedido pedido) {
        try {
            pedido.setId(id);
            Pedido actualizado = pedidoService.save(pedido);
            PedidoDTO dto = PedidoMapper.toPedidoDTO(actualizado);
            return ResponseEntity.ok(dto); // ✅ devolviendo DTO
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar pedido: " + e.getMessage());
        }
    }
    /*
    DELETE:
        Eliminar pedido por ID
    */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            pedidoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al eliminar pedido: " + e.getMessage());
        }
    }


    /*
    OTRO:
        Método para construir lista de respuestas
    */
    private ResponseEntity<List<PedidoDTO>> construirRespuestaListaPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<PedidoDTO> pedidosDTO = pedidos.stream()
                .map(PedidoMapper::toPedidoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidosDTO);
    }
}
