package com.example.restauranteApi.mapper;

import com.example.restauranteApi.dto.ProductoDTO;
import com.example.restauranteApi.dto.ProductoSimpleDTO;
import com.example.restauranteApi.model.Producto;

public class ProductoMapper {

    public static ProductoDTO toProductoDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setProductoId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setCategoria(producto.getCategoria());
        return dto;
    }
}
