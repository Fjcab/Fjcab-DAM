package com.example.restauranteApi.services.implementation;


import com.example.restauranteApi.model.Cliente;
import com.example.restauranteApi.repository.ClienteRepository;
import com.example.restauranteApi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente findByEmail(String correo) {
        return clienteRepository.findByEmail(correo);
    }

    @Override
    public List<Cliente> findByNombreContainingIgnoreCase(String nombre) {
        return clienteRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public Cliente save(Cliente cliente) {
        if (cliente.getId() != null) {
            // Actualización parcial
            Cliente clienteExistente = clienteRepository.findById(cliente.getId()).orElse(null);
            if (clienteExistente != null) {
                if (cliente.getNombre() != null) {
                    clienteExistente.setNombre(cliente.getNombre());
                }
                if (cliente.getTelefono() != null) {
                    clienteExistente.setTelefono(cliente.getTelefono());
                }
                if (cliente.getDireccion() != null) {
                    clienteExistente.setDireccion(cliente.getDireccion());
                }
                if (cliente.getEmail() != null && !cliente.getEmail().equals(clienteExistente.getEmail())) {
                    if (clienteRepository.findByEmail(cliente.getEmail()) != null) {
                        throw new RuntimeException("Ya existe un cliente registrado con ese correo.");
                    }
                    clienteExistente.setEmail(cliente.getEmail());
                }
                return clienteRepository.save(clienteExistente);
            }
        } else {
            if (clienteRepository.findByEmail(cliente.getEmail()) != null) {
                throw new RuntimeException("Ya existe un cliente registrado con ese correo.");
            }
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateByCorreo(String correo, Cliente clienteNuevo) {
        Cliente clienteExistente = clienteRepository.findByEmail(correo);
        if (clienteExistente == null) {
            return null;
        }

        if (clienteNuevo.getNombre() != null) {
            clienteExistente.setNombre(clienteNuevo.getNombre());
        }
        if (clienteNuevo.getTelefono() != null) {
            clienteExistente.setTelefono(clienteNuevo.getTelefono());
        }
        if (clienteNuevo.getDireccion() != null) {
            clienteExistente.setDireccion(clienteNuevo.getDireccion());
        }
        if (clienteNuevo.getEmail() != null) {
            clienteExistente.setEmail(clienteNuevo.getEmail());
        }

        return clienteRepository.save(clienteExistente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void deleteByEmail(String correo) {
        Cliente existente = findByEmail(correo);
        if (existente != null) {
            clienteRepository.delete(existente);
        } else {
            throw new RuntimeException("Cliente no encontrado con correo: " + correo);
        }
    }
}