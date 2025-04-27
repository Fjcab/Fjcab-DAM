package com.example.restauranteApi.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoSimpleDTO {

    private Long productoId;
    private String nombre;
    private BigDecimal precio;

    public ProductoSimpleDTO() {
    }

    public ProductoSimpleDTO(Long productoId, String nombre, BigDecimal precio) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
