package org.mercadodominio.controllers;

import org.mercadodominio.models.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private List<Cliente> listaClientes = new ArrayList<>();

    @GetMapping
    public List<Cliente> getAllClientes() {
        return listaClientes;
    }

    @PostMapping
    public void Cliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    @PutMapping("/{CLIENTE_ID}")
    public ResponseEntity<Cliente> Cliente(@PathVariable("CLIENTE_ID") int id, @RequestBody Cliente clienteAtualizado) {
        listaClientes = listaClientes.stream().filter(c -> c.getClienteId() == id).collect(Collectors.toList());
        for (Cliente c : listaClientes) {
            c.setClienteNome(clienteAtualizado.getClienteNome());
            c.setClienteEmail(clienteAtualizado.getClienteEmail());
            c.setClienteIdade(clienteAtualizado.getClienteIdade());
            return ResponseEntity.ok(c);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public void deleteCliente(int id) {
        listaClientes.removeIf(c -> c.getClienteId() == id);
    }

}
