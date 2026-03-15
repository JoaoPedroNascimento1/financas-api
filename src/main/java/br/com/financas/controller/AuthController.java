package br.com.financas.controller;

import br.com.financas.configuration.TokenConfig;
import br.com.financas.entity.Usuario;
import br.com.financas.mapper.UsuarioMapper;
import br.com.financas.request.LoginRequest;
import br.com.financas.request.UsuarioRequest;
import br.com.financas.response.LoginResponse;
import br.com.financas.response.UsuarioResponse;
import br.com.financas.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final UserService userService;
  private final AuthenticationManager authenticationManager;
  private final TokenConfig tokenConfig;

  @PostMapping("/register")
  public ResponseEntity<UsuarioResponse> register(@Valid @RequestBody UsuarioRequest usuarioRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toUsuarioResponse(userService.register(UsuarioMapper.toUsuario(usuarioRequest))));
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.email(),loginRequest.senha());
    Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

    Usuario user = (Usuario) authentication.getPrincipal();
    String token = tokenConfig.generateToken(user);
    return ResponseEntity.ok(new LoginResponse(token));
  }
}
