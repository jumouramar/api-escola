package com.api.escola.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    // Um aluno pode ter 0 ou N inscrições
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    // Uma turma pode ter 0 ou N inscrições
    @ManyToOne
    @JoinColumn(name = "turma_id", nullable = false)
    private Turma turma;
}