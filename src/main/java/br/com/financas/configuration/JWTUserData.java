package br.com.financas.configuration;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String email) {
}
