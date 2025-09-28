package com.api.escola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer cargaHoraria;

    // Uma disciplina pode ter 0 ou N turmas
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
    @JsonIgnore // impede serializacao infinita
    private List<Turma> turmas;
}
