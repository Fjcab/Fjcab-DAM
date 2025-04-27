package com.example.restauranteApi.repository;

import com.example.restauranteApi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombreContainingIgnoreCase(String nombre);
    Cliente findByEmail(String email);
}
