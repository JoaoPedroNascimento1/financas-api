package br.com.financas.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record LoginRequest(@NotBlank(message = "E-mail obrigatório!") String email,
                           @NotBlank(message = "Senha obrigatória") String senha) {
}
