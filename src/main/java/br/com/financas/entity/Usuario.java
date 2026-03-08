package br.com.financas.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false,unique = true)
  private String email;

  @Column(nullable = false)
  private String senha;
}
