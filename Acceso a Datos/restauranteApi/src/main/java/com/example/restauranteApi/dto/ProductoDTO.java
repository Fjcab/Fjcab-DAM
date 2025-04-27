package com.example.restauranteApi.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoDTO {

    private Long productoId;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String categoria;

    public ProductoDTO() {
    }

    public ProductoDTO(Long productoId, String nombre, String descripcion, BigDecimal precio, String categoria) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
