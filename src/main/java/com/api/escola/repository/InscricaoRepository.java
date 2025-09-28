package com.api.escola.repository;

import com.api.escola.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    @Query("select i from Inscricao i left outer join fetch i.aluno left outer join fetch i.turma order by i.id")
    List<Inscricao> recuperarInscricoes();
}