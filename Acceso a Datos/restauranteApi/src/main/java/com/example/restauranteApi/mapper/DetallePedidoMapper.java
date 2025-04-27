package com.example.restauranteApi.mapper;

import com.example.restauranteApi.dto.DetallePedidoDTO;
import com.example.restauranteApi.dto.ProductoSimpleDTO;
import com.example.restauranteApi.model.DetallePedido;
import com.example.restauranteApi.model.Producto;

public class DetallePedidoMapper {

    public static DetallePedidoDTO toDetallePedidoDTO(DetallePedido detallePedido) {
        if (detallePedido == null) return null;
        return new DetallePedidoDTO(
                detallePedido.getId(),
                detallePedido.getCantidad(),
                detallePedido.getPrecioUnitario(),
                detallePedido.getSubtotal(),
                toProductoSimpleDTO(detallePedido.getProducto())
        );
    }

    private static ProductoSimpleDTO toProductoSimpleDTO(Producto producto) {
        if (producto == null) return null;
        return new ProductoSimpleDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio()
        );
    }
}
