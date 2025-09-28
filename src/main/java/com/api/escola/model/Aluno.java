package com.api.escola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    // Um aluno pode ter 0 ou N inscrições
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    @JsonIgnore // impede serializacao infinita
    private List<Inscricao> inscricoes;
}