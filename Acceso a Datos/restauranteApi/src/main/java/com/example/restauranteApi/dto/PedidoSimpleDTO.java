package com.example.restauranteApi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PedidoSimpleDTO {

    private Long pedidoId;
    private LocalDateTime fecha;
    private BigDecimal total;

    public PedidoSimpleDTO() {
    }

    public PedidoSimpleDTO(Long pedidoId, LocalDateTime fecha, BigDecimal total) {
        this.pedidoId = pedidoId;
        this.fecha = fecha;
        this.total = total;
    }

    // Getters y Setters

    public Long getPedidoId() { return pedidoId; }
    public void setPedidoId(Long pedidoId) { this.pedidoId = pedidoId; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
