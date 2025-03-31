package org.mercadodominio.controllers;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.mercadodominio.models.Cliente;
import org.mercadodominio.models.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/funcionarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FuncionarioController {

    private List<Funcionario> listaFuncionarios = new ArrayList<>(); // Lista todos os produtos
    
    @GET
    public List<Funcionario> getAllUFuncionarios() {
        return Funcionario.listAll();
    }
    
    @GET
    @Path("/{id}")
    public Funcionario getFuncionarioById(@PathParam("id") Long id) {
        return Funcionario.findById(id);
    }

    @POST
    @Transactional
    public Funcionario addFuncionario(@RequestBody Funcionario funcionario) {
        funcionario.persist();
        return funcionario;
    }

    @PUT
    @Path("/{id}")
    public ResponseEntity<Funcionario> editFuncionario(@PathParam("id") Long id, @RequestBody Funcionario funcionarioAtualizado) {
        listaFuncionarios = listaFuncionarios.stream().filter(f -> f.funcionarioId == id).collect(Collectors.toList());
        for (Funcionario u : listaFuncionarios) {
            u.funcionarioNome = funcionarioAtualizado.funcionarioNome;
            u.funcionarioEmail = funcionarioAtualizado.funcionarioEmail;
            u.funcionarioIdade = funcionarioAtualizado.funcionarioIdade;
            return ResponseEntity.ok(u);
        }

        return ResponseEntity.notFound().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteFuncionario(@PathParam("id") Long id) {
        boolean deleted = Cliente.deleteById(id); // Deleta o produto pelo ID
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
