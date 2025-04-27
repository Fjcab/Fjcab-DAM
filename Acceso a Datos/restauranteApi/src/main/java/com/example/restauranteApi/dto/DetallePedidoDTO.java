package com.example.restauranteApi.dto;

import lombok.Data;

@Data
public class DetallePedidoDTO {

    private Long detallePedidoId;
    private int cantidad;
    private Double precioUnitario;
    private Double subtotal;
    private ProductoSimpleDTO producto;

    public DetallePedidoDTO() {
    }

    public DetallePedidoDTO(Long detallePedidoId, int cantidad, Double precioUnitario, Double subtotal, ProductoSimpleDTO producto) {
        this.detallePedidoId = detallePedidoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    // Getters y Setters
    public Long getDetallePedidoId() { return detallePedidoId; }
    public void setDetallePedidoId(Long detallePedidoId) { this.detallePedidoId = detallePedidoId; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }

    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }

    public ProductoSimpleDTO getProducto() { return producto; }
    public void setProducto(ProductoSimpleDTO producto) { this.producto = producto; }
}
