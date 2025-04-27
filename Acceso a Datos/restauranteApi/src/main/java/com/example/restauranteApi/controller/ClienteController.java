package com.example.restauranteApi.controller;

import com.example.restauranteApi.dto.ClienteDTO;
import com.example.restauranteApi.mapper.ClienteMapper;
import com.example.restauranteApi.model.Cliente;
import com.example.restauranteApi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /*
    GET:
        Buscar todos
        Buscar por ID
     */
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteService.findAll();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        List<ClienteDTO> clientesDTO = clientes.stream()
                .map(ClienteMapper::toClienteDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clientesDTO); // 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente no encontrado con ID: " + id);
        }
        ClienteDTO clienteDTO = ClienteMapper.toClienteDTO(cliente);
        return ResponseEntity.ok(clienteDTO);
    }

    /*
    POST:
        Agregar cliente JSON
        Agregar cliente form
        Buscar por nombre
        Buscar por correo JSON
        Buscar por correo form
     */
    @PostMapping
    public ResponseEntity<?> agregarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente nuevoCliente = clienteService.save(cliente);
            ClienteDTO clienteDTO = ClienteMapper.toClienteDTO(nuevoCliente);
            return ResponseEntity.ok(clienteDTO); // 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear cliente: " + e.getMessage());
        }
    }

    @PostMapping("/form")
    public ResponseEntity<?> agregarClienteForm(
            @RequestParam("nombre") String nombre,
            @RequestParam("email") String email,
            @RequestParam("telefono") String telefono,
            @RequestParam("direccion") String direccion) {
        try {
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setDireccion(direccion);

            Cliente guardado = clienteService.save(cliente);
            ClienteDTO clienteDTO = ClienteMapper.toClienteDTO(guardado);

            return ResponseEntity.ok(clienteDTO); // 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear cliente: " + e.getMessage());
        }
    }

    @PostMapping("/nombre")
    public ResponseEntity<List<ClienteDTO>> buscarClientePorNombre(@RequestBody Map<String, String> body) {
        String nombre = body.get("nombre");
        List<Cliente> clientes = clienteService.findByNombreContainingIgnoreCase(nombre);
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        List<ClienteDTO> clientesDTO = clientes.stream()
                .map(ClienteMapper::toClienteDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clientesDTO); // 200 OK
    }

    @PostMapping("/nombre-form")
    public ResponseEntity<List<ClienteDTO>> buscarClientePorNombreForm(@RequestParam("nombre") String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        }
        List<Cliente> clientes = clienteService.findByNombreContainingIgnoreCase(nombre);
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        List<ClienteDTO> clientesDTO = clientes.stream()
                .map(ClienteMapper::toClienteDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clientesDTO); // 200 OK
    }

    @PostMapping("/correo")
    public ResponseEntity<?> buscarClientePorCorreoJSON(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        Cliente cliente = clienteService.findByEmail(correo);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente no encontrado con correo: " + correo);
        }
        ClienteDTO clienteDTO = ClienteMapper.toClienteDTO(cliente);
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping("/correo-form")
    public ResponseEntity<?> buscarClientePorCorreoForm(@RequestParam("correo") String correo) {
        if (correo == null || correo.isEmpty()) {
            return ResponseEntity.badRequest().body("Correo no puede ser vacío"); // 400
        }
        Cliente cliente = clienteService.findByEmail(correo);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente no encontrado con correo: " + correo);
        }
        ClienteDTO clienteDTO = ClienteMapper.toClienteDTO(cliente);
        return ResponseEntity.ok(clienteDTO);
    }

    /*
    PUT:
        Actualizar por ID
        Actualizar por correo
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarClientePorId(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            cliente.setId(id);
            Cliente actualizado = clienteService.save(cliente);
            if (actualizado == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Cliente no encontrado con ID: " + id);
            }
            ClienteDTO clienteDTO = ClienteMapper.toClienteDTO(actualizado);
            return ResponseEntity.ok(clienteDTO); // 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar cliente: " + e.getMessage());
        }
    }

    @PutMapping("/correo")
    public ResponseEntity<?> actualizarClientePorCorreo(@RequestBody Map<String, Object> body) {
        try {
            String correo = (String) body.get("correo");
            Cliente cliente = ClienteMapper.mapToClienteFromMap(body);
            Cliente actualizado = clienteService.updateByCorreo(correo, cliente);
            if (actualizado == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Cliente no encontrado con correo: " + correo);
            }
            ClienteDTO clienteDTO = ClienteMapper.toClienteDTO(actualizado);
            return ResponseEntity.ok(clienteDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar cliente: " + e.getMessage());
        }
    }

    @PutMapping("/correo-form")
    public ResponseEntity<?> actualizarClientePorCorreoForm(
            @RequestParam("correo") String correo,
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "telefono", required = false) String telefono,
            @RequestParam(value = "direccion", required = false) String direccion) {

        if (correo == null || correo.isEmpty()) {
            return ResponseEntity.badRequest().body("Correo no puede ser vacío"); // 400
        }

        Cliente existente = clienteService.findByEmail(correo);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente no encontrado con correo: " + correo);
        }

        if (nombre != null) existente.setNombre(nombre);
        if (telefono != null) existente.setTelefono(telefono);
        if (direccion != null) existente.setDireccion(direccion);

        Cliente actualizado = clienteService.save(existente);
        ClienteDTO clienteDTO = ClienteMapper.toClienteDTO(actualizado);
        return ResponseEntity.ok(clienteDTO); // 200 OK
    }

    /*
    DELETE:
        Eliminar cliente por ID
        Eliminar cliente por correo
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarClientePorId(@PathVariable Long id) {
        try {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al eliminar cliente: " + e.getMessage());
        }
    }

    @DeleteMapping("/correo")
    public ResponseEntity<?> eliminarClientePorCorreo(@RequestBody Map<String, String> body) {
        try {
            String correo = body.get("correo");
            clienteService.deleteByEmail(correo);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al eliminar cliente: " + e.getMessage());
        }
    }

    @DeleteMapping("/correo-form")
    public ResponseEntity<?> eliminarClientePorCorreoForm(@RequestParam("correo") String correo) {
        if (correo == null || correo.isEmpty()) {
            return ResponseEntity.badRequest().body("Correo no puede ser vacío"); // 400
        }
        try {
            clienteService.deleteByEmail(correo);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al eliminar cliente: " + e.getMessage());
        }
    }
}
