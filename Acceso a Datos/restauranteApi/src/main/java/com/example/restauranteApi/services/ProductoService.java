package com.example.restauranteApi.services;

import com.example.restauranteApi.model.Producto;

import java.util.List;


public interface ProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto findByNombre(String nombre);
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByCategoria(String categoria);
    Producto save(Producto producto);
    Producto updateByNombre(String nombre, Producto producto);
    void deleteById(Long id);
    void deleteByNombre(String nombre);
}
