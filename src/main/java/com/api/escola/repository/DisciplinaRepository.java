package com.api.escola.repository;

import com.api.escola.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    @Query("select d from Disciplina d left outer join fetch d.turmas order by d.id")
    List<Disciplina> recuperarDisciplinas();
}