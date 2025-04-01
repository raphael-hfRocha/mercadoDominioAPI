package org.mercadodominio.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
@Entity
@Table(name = "PRODUTO")
public class Produto extends PanacheEntityBase {
    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura o auto-incremento
    @Column(name = "PRODUTO_ID")
    private Long produtoId;
    @Column(name = "PRODUTO_NOME", nullable = false)
    private String produtoNome;
    @Column(name = "CATEGORIA_ID", nullable = false)
    private int categoriaId;
    @Column(name = "PRODUTO_DESCRICAO", nullable = false)
    private String produtoDescricao;
    @Column(name = "PRODUTO_PRECO", nullable = false)
    private Double produtoPreco;
}