package com.example.restauranteApi.services;

import com.example.restauranteApi.model.Cliente;

import java.util.List;


public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente findByEmail(String correo);
    List<Cliente> findByNombreContainingIgnoreCase(String nombre);
    Cliente save(Cliente cliente);
    Cliente updateByCorreo(String correo, Cliente cliente);
    void deleteById(Long id);
    void deleteByEmail(String correo);
}
