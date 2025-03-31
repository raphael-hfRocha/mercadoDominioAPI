package org.mercadodominio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor // Gera um construtor com todos os argumentos
@ToString // Gera o método toString()
@EqualsAndHashCode // Gera equals() e hashCode()
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario extends PanacheEntityBase {
    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura o auto-incremento
    @Column(name = "FUNCIONARIO_ID")
    public Long funcionarioId;
    @Column(name = "FUNCIONARIO_NOME")
    public String funcionarioNome;
    @Column(name = "FUNCIONARIO_EMAIL")
    public String funcionarioEmail;
    @Column(name = "FUNCIONARIO_IDADE")
    public int funcionarioIdade;
}
