package com.example.restauranteApi.mapper;

import com.example.restauranteApi.dto.PedidoDTO;
import com.example.restauranteApi.model.Pedido;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {

    public static PedidoDTO toPedidoDTO(Pedido pedido) {
        if (pedido == null) return null;
        return new PedidoDTO(
                pedido.getId(),
                pedido.getFecha(),
                pedido.getTotal(),
                pedido.getCliente() != null ? pedido.getCliente().getId() : null,
                pedido.getDetalles() != null
                        ? pedido.getDetalles().stream()
                        .map(DetallePedidoMapper::toDetallePedidoDTO)
                        .collect(Collectors.toList())
                        : null
        );
    }
}
