package br.com.financas.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UsuarioRequest(@NotBlank(message = "Nome obrigatório!") String nome,
                             @NotBlank(message = "Email obrigatório!") String email,
                             @NotBlank(message = "Senha obrigatória!") String senha) {
}
