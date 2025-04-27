package com.example.restauranteApi.services.implementation;

import com.example.restauranteApi.dto.DetallePedidoDTO;
import com.example.restauranteApi.dto.PedidoDTO;
import com.example.restauranteApi.mapper.PedidoMapper;
import com.example.restauranteApi.model.DetallePedido;
import com.example.restauranteApi.model.Pedido;
import com.example.restauranteApi.mapper.DetallePedidoMapper;
import com.example.restauranteApi.repository.PedidoRepository;
import com.example.restauranteApi.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImp implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Pedido save(Pedido pedido) {
        Pedido existente = null;
        if (pedido.getId() != null) {
            existente = pedidoRepository.findById(pedido.getId()).orElse(null);
        }
        if (existente != null) {
            // Actualizar campos básicos
            if (pedido.getFecha() != null) {
                existente.setFecha(pedido.getFecha());
            }
            if (pedido.getTotal() != null) {
                existente.setTotal(pedido.getTotal());
            }
            if (pedido.getCliente() != null) {
                existente.setCliente(pedido.getCliente());
            }

            if (pedido.getDetalles() != null) {
                // Limpiar detalles anteriores
                existente.getDetalles().clear();

                List<DetallePedido> nuevosDetalles = new ArrayList<>();

                for (DetallePedido detalleNuevo : pedido.getDetalles()) {
                    detalleNuevo.setPedido(existente); // importante
                    nuevosDetalles.add(detalleNuevo);
                }

                existente.getDetalles().addAll(nuevosDetalles);
            }

            return pedidoRepository.save(existente);
        }

        return pedidoRepository.save(pedido);
    }

    @Override
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public List<Pedido> findByFecha(LocalDateTime fecha) {
        return pedidoRepository.findByFecha(fecha);
    }

    @Override
    public List<Pedido> findByTotalGreaterThanEqual(BigDecimal total) {
        return pedidoRepository.findByTotalGreaterThanEqual(total);
    }

    @Override
    public List<Pedido> findByFechaAndTotal(LocalDateTime fecha, BigDecimal total) {
        return pedidoRepository.findByFechaAndTotal(fecha, total);
    }

    // Cliente
    @Override
    public List<Pedido> findByClienteId(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    @Override
    public List<Pedido> findByClienteIdAndFecha(Long clienteId, LocalDateTime fecha) {
        return pedidoRepository.findByClienteIdAndFecha(clienteId, fecha);
    }

    @Override
    public List<Pedido> findByClienteIdAndTotal(Long clienteId, BigDecimal total) {
        return pedidoRepository.findByClienteIdAndTotal(clienteId, total);
    }

    @Override
    public List<Pedido> findByClienteIdAndFechaAndTotal(Long clienteId, LocalDateTime fecha, BigDecimal total) {
        return pedidoRepository.findByClienteIdAndFechaAndTotal(clienteId, fecha, total);
    }

    // Producto
    @Override
    public List<Pedido> findByProductoId(Long productoId) {
        return pedidoRepository.findByProductoId(productoId);
    }

    @Override
    public List<Pedido> findByProductoIdAndFecha(Long productoId, LocalDateTime fecha) {
        return pedidoRepository.findByProductoIdAndFecha(productoId, fecha);
    }

    @Override
    public List<Pedido> findByProductoIdAndTotal(Long productoId, BigDecimal total) {
        return pedidoRepository.findByProductoIdAndTotal(productoId, total);
    }

    @Override
    public List<Pedido> findByProductoIdAndFechaAndTotal(Long productoId, LocalDateTime fecha, BigDecimal total) {
        return pedidoRepository.findByProductoIdAndFechaAndTotal(productoId, fecha, total);
    }

    // Cliente + Producto
    @Override
    public List<Pedido> findByClienteIdAndProductoId(Long clienteId, Long productoId) {
        return pedidoRepository.findByClienteIdAndProductoId(clienteId, productoId);
    }

    @Override
    public List<Pedido> findByClienteIdAndProductoIdAndTotal(Long clienteId, Long productoId, BigDecimal total) {
        return pedidoRepository.findByClienteIdAndProductoIdAndTotal(clienteId, productoId, total);
    }

    @Override
    public List<Pedido> findByClienteIdAndFechaAndProductoId(Long clienteId, LocalDateTime fecha, Long productoId) {
        return pedidoRepository.findByClienteIdAndFechaAndProductoId(clienteId, fecha, productoId);
    }

    @Override
    public List<Pedido> findByClienteIdAndFechaAndProductoIdAndTotal(Long clienteId, LocalDateTime fecha, Long productoId, BigDecimal total) {
        return pedidoRepository.findByClienteIdAndFechaAndProductoIdAndTotal(clienteId, fecha, productoId, total);
    }
}
