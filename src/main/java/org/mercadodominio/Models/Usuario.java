package org.mercadodominio.Models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

@Getter // Gera getters para todos os campos
@Setter // Gera setters para todos os campos
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor // Gera um construtor com todos os argumentos
@ToString // Gera o método toString()
@EqualsAndHashCode // Gera equals() e hashCode()

public class Usuario extends PanacheEntity {
    private int UsuarioId;
    private String UsuarioNome;
    private String UsuarioEmail;
    private int UsuarioIdade;

    public Usuario(int usuarioId, String usuarioNome, String usuarioEmail, int usuarioIdade) {
        UsuarioId = usuarioId;
        UsuarioNome = usuarioNome;
        UsuarioEmail = usuarioEmail;
        UsuarioIdade = usuarioIdade;
    }
}
