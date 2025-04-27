package com.example.restauranteApi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoDTO {

    private Long pedidoId;
    private LocalDateTime fecha;
    private BigDecimal total;
    private Long clienteId;
    private List<DetallePedidoDTO> detalles;

    public PedidoDTO() {
    }

    public PedidoDTO(Long pedidoId, LocalDateTime fecha, BigDecimal total, Long clienteId, List<DetallePedidoDTO> detalles) {
        this.pedidoId = pedidoId;
        this.fecha = fecha;
        this.total = total;
        this.clienteId = clienteId;
        this.detalles = detalles;
    }



    // Getters y Setters
    public Long getPedidoId() { return pedidoId; }
    public void setPedidoId(Long pedidoId) { this.pedidoId = pedidoId; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long total) { this.clienteId = total; }

    public List<DetallePedidoDTO> getDetalles() { return detalles; }
    public void setDetalles(List<DetallePedidoDTO> detalles) { this.detalles = detalles; }
}
