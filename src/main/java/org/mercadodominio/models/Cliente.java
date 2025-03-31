package org.mercadodominio.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import java.lang.Long;

@AllArgsConstructor // Gera um construtor com todos os argumentos
@NoArgsConstructor // Gera um construtor sem argumentos
@ToString // Gera o método toString()
@EqualsAndHashCode // Gera equals() e hashCode()
@Entity
@Table(name = "CLIENTE")
public class Cliente extends PanacheEntityBase {

    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura o auto-incremento
    @Column(name = "CLIENTE_ID")
    public Long ClienteId;
    @Column(name = "CLIENTE_NOME", nullable = false)
    public String ClienteNome;
    @Column(name = "CLIENTE_EMAIL", nullable = false, unique = true)
    public String ClienteEmail;
    @Column(name = "CLIENTE_IDADE", nullable = false)
    public int ClienteIdade;
}
