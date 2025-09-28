package com.api.escola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private String periodo;

    // Uma turma possui 1 professor
    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonIgnoreProperties("turmas")
    private Professor professor;

    // Uma turma pode ter 0 ou N inscrições
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    @JsonIgnore // impede serializacao infinita
    private List<Inscricao> inscricoes;

    // Uma turma possui 1 disciplina
    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    @JsonIgnoreProperties("turmas")
    private Disciplina disciplina;
}