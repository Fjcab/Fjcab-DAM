package com.example.restauranteApi.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {

    private Long clienteId;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private List<PedidoSimpleDTO> pedidos;

    public ClienteDTO() {
    }

    public ClienteDTO(Long clienteId, String nombre, String email, String telefono, String direccion, List<PedidoSimpleDTO> pedidos) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.pedidos = pedidos;
    }

    // Getters y Setters

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public List<PedidoSimpleDTO> getPedidos() { return pedidos; }
    public void setPedidos(List<PedidoSimpleDTO> pedidos) { this.pedidos = pedidos; }
}
