package com.example.restauranteApi.services.implementation;

import com.example.restauranteApi.model.Producto;
import com.example.restauranteApi.repository.ProductoRepository;
import com.example.restauranteApi.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto findByNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @Override
    public List<Producto> findByNombreContainingIgnoreCase(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Producto> findByCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    @Override
    public Producto save(Producto producto) {
        if (producto.getId() != null) {
            Producto existente = productoRepository.findById(producto.getId()).orElse(null);
            if (existente != null) {
                if (producto.getNombre() != null) {
                    existente.setNombre(producto.getNombre());
                }
                if (producto.getDescripcion() != null) {
                    existente.setDescripcion(producto.getDescripcion());
                }
                if (producto.getPrecio() != null) {
                    existente.setPrecio(producto.getPrecio());
                }
                if (producto.getCategoria() != null) {
                    existente.setCategoria(producto.getCategoria());
                }
                return productoRepository.save(existente);
            }
        }
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateByNombre(String nombre, Producto nuevoProducto) {
        Producto existente = productoRepository.findByNombre(nombre);
        if (existente != null) {
            if (nuevoProducto.getDescripcion() != null) {
                existente.setDescripcion(nuevoProducto.getDescripcion());
            }
            if (nuevoProducto.getPrecio() != null) {
                existente.setPrecio(nuevoProducto.getPrecio());
            }
            if (nuevoProducto.getCategoria() != null) {
                existente.setCategoria(nuevoProducto.getCategoria());
            }
            return productoRepository.save(existente);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public void deleteByNombre(String nombre) {
        Producto producto = productoRepository.findByNombre(nombre);
        if (producto != null) {
            productoRepository.deleteById(producto.getId());
        }
    }
}
