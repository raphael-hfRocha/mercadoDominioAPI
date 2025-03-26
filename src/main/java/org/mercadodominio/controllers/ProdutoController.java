package org.mercadodominio.controllers;

import org.mercadodominio.models.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produto> listaProdutos = new ArrayList<>();

    @GetMapping
    public List<Produto> getAllUProdutos() {
        return listaProdutos;
    }

    @PostMapping
    public void addProduto(Produto funcionario) {
        listaProdutos.add(funcionario);
    }

    @PutMapping("/{PRODUTO_ID}")
    public ResponseEntity<Produto> editProduto(@PathVariable("PRODUTO_ID") int id, @RequestBody Produto funcionarioAtualizado) {
        listaProdutos = listaProdutos.stream().filter(f -> f.getProdutoId() == id).collect(Collectors.toList());
        for (Produto u : listaProdutos) {
            u.setProdutoNome(funcionarioAtualizado.getProdutoNome());
            u.setCategoriaId(funcionarioAtualizado.getCategoriaId());
            u.setProdutoDescricao(funcionarioAtualizado.getProdutoDescricao());
            u.setProdutoPreco(funcionarioAtualizado.getProdutoPreco());
            return ResponseEntity.ok(u);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public void deleteProduto(int id) {
        listaProdutos.removeIf(f -> f.getProdutoId() == id);
    }

}
