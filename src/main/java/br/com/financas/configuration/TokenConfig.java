package br.com.financas.configuration;

import br.com.financas.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {

  private String secret = "secret";

  public String generateToken(Usuario usuario) {
    Algorithm algorithm = Algorithm.HMAC256(secret);

    return JWT.create()
      .withClaim("userId",usuario.getId())
      .withSubject(usuario.getEmail())
      .withExpiresAt(Instant.now().plusSeconds(86400))
      .withIssuedAt(Instant.now())
      .sign(algorithm);
  }

  public Optional<JWTUserData> validateToken(String token) {
    Algorithm algorithm = Algorithm.HMAC256(secret);

    DecodedJWT jwt = JWT.require(algorithm)
      .build()
      .verify(token);

    return Optional.of(JWTUserData
      .builder()
      .id(jwt.getClaim("userId").asLong())
      .email(jwt.getSubject())
      .build());
  }
}
