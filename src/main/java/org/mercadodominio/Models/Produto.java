package org.mercadodominio.Models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter // Gera getters para todos os campos
@Setter // Gera setters para todos os campos
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor // Gera um construtor com todos os argumentos
@ToString // Gera o método toString()
@EqualsAndHashCode // Gera equals() e hashCode()


@Entity
public class Produto extends PanacheEntity  {
    private int ProdutoId;
    private String ProdutoNome;
    private String ProdutoDescricao;
    private Double ProdutoPreco;


    public Produto(int produtoId, String produtoNome, String produtoDescricao, Double produtoPreco) {
        ProdutoId = produtoId;
        ProdutoNome = produtoNome;
        ProdutoDescricao = produtoDescricao;
        ProdutoPreco = produtoPreco;
    }
}
