package org.mercadodominio.controllers;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mercadodominio.models.Produto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {

    @GET
    public List<Produto> getAllProdutos() {
        return Produto.listAll(); // Método do PanacheEntity para listar todos os produtos
    }

    @GET
    @Path("/{id}")
    public Response getProdutoById(@PathParam("id") Long id) {
        Produto produto = Produto.findById(id);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Produto não encontrado").build();
        }
        return Response.ok(produto).build();
    }

    @POST
    @Transactional
    public Response criarProduto(Produto produto) {
        // Validação básica dos campos obrigatórios
        if (produto.getProdutoNome() == null || produto.getProdutoNome().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Nome do produto é obrigatório").build();
        }

        // Garante que é um novo produto (ID deve ser nulo)
        if (produto.getProdutoId() != null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("ID não deve ser fornecido para um novo produto").build();
        }

        // Persiste o novo produto
        produto.persist();

        return Response.status(Response.Status.CREATED).entity(produto).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarProduto(@PathParam("id") Long id, @RequestBody Produto produtoAtualizado) {
        Produto produto = Produto.findById(id);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Produto não encontrado").build();
        }

        if (produtoAtualizado.getProdutoNome() == null || produtoAtualizado.getProdutoNome().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Nome do produto é obrigatório").build();
        }

        produto.setProdutoNome(produtoAtualizado.getProdutoNome());
        produto.setProdutoDescricao(produtoAtualizado.getProdutoDescricao());
        produto.setProdutoPreco(produtoAtualizado.getProdutoPreco());

        return Response.ok(produto).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarProduto(@PathParam("id") Long id) {
        boolean deleted = Produto.deleteById(id); // Deleta o produto pelo ID
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).entity("Produto não encontrado").build();
        }
        return Response.noContent().build();
    }
}