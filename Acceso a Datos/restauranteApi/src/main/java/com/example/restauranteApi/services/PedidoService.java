package com.example.restauranteApi.services;

import com.example.restauranteApi.model.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface PedidoService {
    List<Pedido> findAll();
    Pedido findById(Long id);
    Pedido save(Pedido pedido);
    void deleteById(Long id);


    List<Pedido> findByFecha(LocalDateTime fecha);
    List<Pedido> findByTotalGreaterThanEqual(BigDecimal total);
    List<Pedido> findByFechaAndTotal(LocalDateTime fecha, BigDecimal total);

    // Cliente
    List<Pedido> findByClienteId(Long clienteId);
    List<Pedido> findByClienteIdAndFecha(Long clienteId, LocalDateTime fecha);
    List<Pedido> findByClienteIdAndTotal(Long clienteId, BigDecimal total);
    List<Pedido> findByClienteIdAndFechaAndTotal(Long clienteId, LocalDateTime fecha, BigDecimal total);

    // Producto
    List<Pedido> findByProductoId(Long productoId);
    List<Pedido> findByProductoIdAndFecha(Long productoId, LocalDateTime fecha);
    List<Pedido> findByProductoIdAndTotal(Long productoId, BigDecimal total);
    List<Pedido> findByProductoIdAndFechaAndTotal(Long productoId, LocalDateTime fecha, BigDecimal total);

    // Cliente + Producto
    List<Pedido> findByClienteIdAndProductoId(Long clienteId, Long productoId);
    List<Pedido> findByClienteIdAndProductoIdAndTotal(Long clienteId, Long productoId, BigDecimal total);
    List<Pedido> findByClienteIdAndFechaAndProductoId(Long clienteId, LocalDateTime fecha, Long productoId);
    List<Pedido> findByClienteIdAndFechaAndProductoIdAndTotal(Long clienteId, LocalDateTime fecha, Long productoId, BigDecimal total);
}
