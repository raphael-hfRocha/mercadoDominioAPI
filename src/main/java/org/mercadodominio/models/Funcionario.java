package org.mercadodominio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor // Gera um construtor com todos os argumentos
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario extends PanacheEntityBase {
    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura o auto-incremento
    @Column(name = "FUNCIONARIO_ID")
    private Long funcionarioId;
    @Column(name = "FUNCIONARIO_NOME")
    private String funcionarioNome;
    @Column(name = "FUNCIONARIO_EMAIL")
    private String funcionarioEmail;
    @Column(name = "FUNCIONARIO_IDADE")
    private int funcionarioIdade;
}
