package org.mercadodominio.models;

import com.google.gson.annotations.SerializedName;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter // Gera getters para todos os campos
@Setter // Gera setters para todos os campos
@AllArgsConstructor // Gera um construtor com todos os argumentos
@NoArgsConstructor // Gera um construtor sem argumentos
@ToString // Gera o método toString()
@EqualsAndHashCode // Gera equals() e hashCode()

public class Cliente extends PanacheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SerializedName("CLIENTE_ID")
    private int ClienteId;
    @SerializedName("CLIENTE_NOME")
    private String ClienteNome;
    @SerializedName("CLIENTE_EMAIL")
    private String ClienteEmail;
    @SerializedName("CLIENTE_IDADE")
    private int ClienteIdade;

    public Cliente(String clienteNome, String clienteEmail, int clienteIdade) {
        ClienteNome = clienteNome;
        ClienteEmail = clienteEmail;
        ClienteIdade = clienteIdade;
    }
}
