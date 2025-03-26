package org.mercadodominio.models;

import com.google.gson.annotations.SerializedName;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter // Gera getters para todos os campos
@Setter // Gera setters para todos os campos
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor // Gera um construtor com todos os argumentos
@ToString // Gera o método toString()
@EqualsAndHashCode // Gera equals() e hashCode()

public class Funcionario extends PanacheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SerializedName("FUNCIONARIO_ID")
    private int FuncionarioId;
    @SerializedName("FUNCIONARIO_NOME")
    private String FuncionarioNome;
    @SerializedName("FUNCIONARIO_EMAIL")
    private String FuncionarioEmail;
    @SerializedName("FUNCIONARIO_IDADE")
    private int FuncionarioIdade;

    public Funcionario(String funcionarioNome, String funcionarioEmail, int funcionarioIdade) {
        FuncionarioNome = funcionarioNome;
        FuncionarioEmail = funcionarioEmail;
        FuncionarioIdade = funcionarioIdade;
    }
}
