package com.api.escola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.*;
import java.util.List;

@NoArgsConstructor // gera construtor vazio
@AllArgsConstructor // gera construtor com todos os campos
@Getter // gera métodos de getter
@Setter // gera métodos de setter

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
    private String nome;

    @Column(unique = true)
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    // Um aluno pode ter 0 ou N inscrições
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    @JsonIgnore // impede serializacao infinita
    private List<Inscricao> inscricoes;
}