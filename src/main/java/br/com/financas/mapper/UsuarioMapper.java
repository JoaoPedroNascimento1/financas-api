package br.com.financas.mapper;

import br.com.financas.entity.Usuario;
import br.com.financas.request.UsuarioRequest;
import br.com.financas.response.UsuarioResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

  public Usuario toUsuario(UsuarioRequest usuarioRequest) {
    return Usuario.builder()
      .nome(usuarioRequest.nome())
      .email(usuarioRequest.email())
      .senha(usuarioRequest.senha())
      .build();
  }

  public UsuarioResponse toUsuarioResponse(Usuario usuario) {
    return UsuarioResponse.builder()
      .id(usuario.getId())
      .nome(usuario.getNome())
      .email(usuario.getEmail())
      .build();
  }
}
