package org.mercadodominio.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "PRODUTO")
public class Produto extends PanacheEntityBase {
    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura o auto-incremento
    @Column(name = "PRODUTO_ID")
    public Long produtoId;
    @Column(name = "PRODUTO_NOME", nullable = false)
    public String produtoNome;
    @Column(name = "CATEGORIA_ID", nullable = false)
    public int categoriaId;
    @Column(name = "PRODUTO_DESCRICAO", nullable = false)
    public String produtoDescricao;
    @Column(name = "PRODUTO_PRECO", nullable = false)
    public Double produtoPreco;
    
    public Produto() {}

    @Override
    public String toString() {
        return "Produto{" +
                "ProdutoId=" + produtoId +
                ", ProdutoNome=" + produtoNome + '\'' +
                ", CategoriaId=" + categoriaId +
                ", ProdutoDescricao='" + produtoDescricao + '\'' +
                ", ProdutoPreco=" + produtoPreco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (produtoId != produto.produtoId) return false;
        if (categoriaId != produto.categoriaId) return false;
        if (!produtoNome.equals(produto.produtoNome)) return false;
        if (!produtoDescricao.equals(produto.produtoDescricao)) return false;
        return produtoPreco.equals(produto.produtoPreco);
    }

    // @Override
    // public Long hashCode() {
    //     Long result = ProdutoId;
    //     result = 31 * result + ProdutoNome.hashCode();
    //     result = 31 * result + CategoriaId;
    //     result = 31 * result + ProdutoDescricao.hashCode();
    //     result = 31 * result + ProdutoPreco.hashCode();
    //     return result;
    // }
}