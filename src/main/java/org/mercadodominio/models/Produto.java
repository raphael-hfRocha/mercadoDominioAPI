package org.mercadodominio.models;

import com.google.gson.annotations.SerializedName;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SerializedName("PRODUTO_ID") private int ProdutoId;
    @SerializedName("PRODUTO_NOME") private String ProdutoNome;
    @SerializedName("CATEGORIA_ID") private int CategoriaId;
    @SerializedName("PRODUTO_DESCRICAO") private String ProdutoDescricao;
    @SerializedName("PRODUTO_PRECO") private Double ProdutoPreco;

    public Produto(String produtoNome, int categoriaId, String produtoDescricao, Double produtoPreco) {
        ProdutoNome = produtoNome;
        CategoriaId = categoriaId;
        ProdutoDescricao = produtoDescricao;
        ProdutoPreco = produtoPreco;
    }
}
