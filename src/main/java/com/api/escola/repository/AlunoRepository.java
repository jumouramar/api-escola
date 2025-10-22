package com.api.escola.repository;

import com.api.escola.model.Aluno;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select a from Aluno a where a.id = :id")
    Optional<Aluno> recuperarAlunoPorIdComLock(@Param("id") Long id);

    @Query("select a from Aluno a left outer join fetch a.inscricoes order by a.id")
    List<Aluno> recuperarAlunos();

    @Query("SELECT DISTINCT a FROM Aluno a JOIN a.inscricoes i WHERE i.turma.id = :turmaId")
    List<Aluno> recuperarAlunosPorTurma(@Param("turmaId") Long turmaId);
}