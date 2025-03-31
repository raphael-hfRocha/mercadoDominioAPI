package org.mercadodominio.controllers;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.mercadodominio.models.Funcionario;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Path("/funcionarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FuncionarioController {

    @GET
    public List<Funcionario> getAllUFuncionarios() {
        return Funcionario.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getFuncionarioById(@PathParam("id") Long id) {
        Funcionario funcionario = Funcionario.findById(id);
        if (funcionario == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Funcionario não encontrado").build();
        }
        return Response.ok(funcionario).build();
    }

    @POST
    @Transactional
    public Response addFuncionario(@RequestBody Funcionario funcionario) {
        // Validação básica dos campos obrigatórios
        if (funcionario.funcionarioNome == null || funcionario.funcionarioNome.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Nome do produto é obrigatório").build();
        }

        // Garante que é um novo produto (ID deve ser nulo)
        if (funcionario.funcionarioId != null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("ID não deve ser fornecido para um novo produto").build();
        }

        // Persiste o novo produto
        funcionario.persist();

        return Response.status(Response.Status.CREATED).entity(funcionario).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response editFuncionario(@PathParam("id") Long id,
            @RequestBody Funcionario funcionarioAtualizado) {
        Funcionario funcionario = Funcionario.findById(id);
        if (funcionario == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Produto não encontrado").build();
        }

        if (funcionarioAtualizado.funcionarioNome == null || funcionarioAtualizado.funcionarioNome.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Nome do funcionario é obrigatório").build();
        }

        funcionario.funcionarioNome = funcionarioAtualizado.funcionarioNome;
        funcionario.funcionarioEmail = funcionarioAtualizado.funcionarioEmail;
        funcionario.funcionarioIdade = funcionarioAtualizado.funcionarioIdade;

        return Response.ok(funcionario).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteFuncionario(@PathParam("id") Long id) {
        boolean deleted = Funcionario.deleteById(id); // Deleta o produto pelo ID
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
