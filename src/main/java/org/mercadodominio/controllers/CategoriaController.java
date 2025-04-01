package org.mercadodominio.controllers;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.mercadodominio.models.Categoria;

import java.util.List;

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaController {

    @GET
    public List<Categoria> getAllCategorias() {
        return Categoria.listAll(); // Método do PanacheEntity para listar todas as categorias
    }

    @GET
    @Path("/{id}")
    public Response getCategoriaById(@PathParam("id") Long id) {
        Categoria categoria = Categoria.findById(id);
        if (categoria == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Categoria não encontrada").build();
        }
        return Response.ok(categoria).build();

    }
}
