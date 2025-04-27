package com.example.restauranteApi.mapper;

import com.example.restauranteApi.dto.*;
import com.example.restauranteApi.model.*;

import java.util.Map;
import java.util.stream.Collectors;

public class ClienteMapper {

    public static ClienteDTO toClienteDTO(Cliente cliente) {
        if (cliente == null) return null;
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getDireccion(),
                cliente.getPedidos() != null ? cliente.getPedidos().stream().map(ClienteMapper::toPedidoSimpleDTO).collect(Collectors.toList()) : null
        );
    }

    public static PedidoSimpleDTO toPedidoSimpleDTO(Pedido pedido) {
        if (pedido == null) return null;
        return new PedidoSimpleDTO(
                pedido.getId(),
                pedido.getFecha(),
                pedido.getTotal()
        );
    }

    public static Cliente mapToClienteFromMap(Map<String, Object> body) {
        Cliente cliente = new Cliente();
        cliente.setNombre((String) body.get("nombre"));
        cliente.setTelefono((String) body.get("telefono"));
        cliente.setDireccion((String) body.get("direccion"));
        cliente.setEmail((String) body.get("email"));
        return cliente;
    }
}
