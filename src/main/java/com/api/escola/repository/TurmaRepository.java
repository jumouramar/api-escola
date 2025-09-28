package com.api.escola.repository;

import com.api.escola.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    @Query("select t from Turma t left outer join fetch t.professor left outer join fetch t.inscricoes order by t.id")
    List<Turma> recuperarTurmas();
}