package org.mercadodominio.controllers;

import java.util.List;

import org.mercadodominio.models.Cliente;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {

    @GET
    public List<Cliente> listarClientes() {
        return Cliente.listAll(); // Método do PanacheEntity para listar todos os produtos
    }

    @GET
    @Path("/{id}")
    public Cliente buscarCliente(Long id) {
        return Cliente.findById(id); // Busca um produto pelo ID
    }

    @POST
    @Transactional
    public Cliente adicionarCliente(Cliente cliente) {
        cliente.persist(); // Persiste o produto no banco de dados
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente não pode ser nulo");
        }
        return cliente; // Retorna o produto adicionado
    }
    
    @PUT
    @Path("/id")
    public Response editarCliente(@PathParam("id") Long id, Cliente clienteAtualizado) {
        Cliente cliente = Cliente.findById(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        cliente.ClienteNome = clienteAtualizado.ClienteNome;
        cliente.ClienteEmail = clienteAtualizado.ClienteEmail;
        cliente.ClienteIdade = clienteAtualizado.ClienteIdade;
        cliente.persist();
        return Response.ok(cliente).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirCliente(Long id) {
        boolean deleted = Cliente.deleteById(id); // Deleta o produto pelo ID
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}