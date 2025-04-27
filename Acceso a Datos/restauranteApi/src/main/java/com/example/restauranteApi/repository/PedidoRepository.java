package com.example.restauranteApi.repository;

import com.example.restauranteApi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId(Long clienteId);
    List<Pedido> findByFecha(LocalDateTime fecha);
    List<Pedido> findByTotalGreaterThanEqual(BigDecimal total);

    List<Pedido> findByClienteIdAndFecha(Long clienteId, LocalDateTime fecha);
    List<Pedido> findByClienteIdAndTotal(Long clienteId, BigDecimal total);
    List<Pedido> findByFechaAndTotal(LocalDateTime fecha, BigDecimal total);
    List<Pedido> findByClienteIdAndFechaAndTotal(Long clienteId, LocalDateTime fecha, BigDecimal total);

    // Producto
    @Query("SELECT DISTINCT p FROM Pedido p JOIN p.detalles d WHERE d.producto.id = :productoId")
    List<Pedido> findByProductoId(@Param("productoId") Long productoId);

    @Query("SELECT DISTINCT p FROM Pedido p JOIN p.detalles d WHERE d.producto.id = :productoId AND p.fecha = :fecha")
    List<Pedido> findByProductoIdAndFecha(@Param("productoId") Long productoId, @Param("fecha") LocalDateTime fecha);

    @Query("SELECT DISTINCT p FROM Pedido p JOIN p.detalles d WHERE d.producto.id = :productoId AND p.total = :total")
    List<Pedido> findByProductoIdAndTotal(@Param("productoId") Long productoId, @Param("total") BigDecimal total);

    @Query("SELECT DISTINCT p FROM Pedido p JOIN p.detalles d WHERE d.producto.id = :productoId AND p.fecha = :fecha AND p.total = :total")
    List<Pedido> findByProductoIdAndFechaAndTotal(@Param("productoId") Long productoId, @Param("fecha") LocalDateTime fecha, @Param("total") BigDecimal total);

    // Cliente + Producto
    @Query("SELECT DISTINCT p FROM Pedido p JOIN p.detalles d WHERE p.cliente.id = :clienteId AND d.producto.id = :productoId")
    List<Pedido> findByClienteIdAndProductoId(@Param("clienteId") Long clienteId, @Param("productoId") Long productoId);

    // Cliente + Producto + Total
    @Query("SELECT DISTINCT p FROM Pedido p JOIN p.detalles d WHERE p.cliente.id = :clienteId AND d.producto.id = :productoId AND p.total = :total")
    List<Pedido> findByClienteIdAndProductoIdAndTotal(@Param("clienteId") Long clienteId, @Param("productoId") Long productoId, @Param("total") BigDecimal total);

    // Cliente + Fecha + Producto
    @Query("SELECT DISTINCT p FROM Pedido p JOIN p.detalles d WHERE p.cliente.id = :clienteId AND p.fecha = :fecha AND d.producto.id = :productoId")
    List<Pedido> findByClienteIdAndFechaAndProductoId(@Param("clienteId") Long clienteId, @Param("fecha") LocalDateTime fecha, @Param("productoId") Long productoId);

    // Cliente + Fecha + Producto + Total
    @Query("SELECT DISTINCT p FROM Pedido p JOIN p.detalles d WHERE p.cliente.id = :clienteId AND p.fecha = :fecha AND d.producto.id = :productoId AND p.total = :total")
    List<Pedido> findByClienteIdAndFechaAndProductoIdAndTotal(@Param("clienteId") Long clienteId, @Param("fecha") LocalDateTime fecha, @Param("productoId") Long productoId, @Param("total") BigDecimal total);
}
