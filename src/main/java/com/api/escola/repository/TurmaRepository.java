package com.api.escola.repository;

import com.api.escola.model.Aluno;
import com.api.escola.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    @Query("""
        select t from Turma t 
        left outer join fetch t.professor 
        left outer join fetch t.inscricoes 
        order by t.id
    """)
    List<Turma> recuperarTurmas();
    
    @Query("""
        select distinct t from Turma t
        left join fetch t.professor
        left join fetch t.inscricoes
        where t.disciplina.id = :disciplinaId
        order by t.id
    """)
    List<Turma> recuperarTurmasPorDisciplina(@Param("disciplinaId") Long disciplinaId);

    @Query("""
        select distinct a
        from Aluno a
        where exists (
            select 1 from Inscricao i
            where i.aluno = a
              and i.turma.id = :turmaId
        )
        order by a.id desc
    """)
    List<Aluno> recuperarAlunosInscritos(@Param("turmaId") Long turmaId);

    @Query("""
        select distinct a
        from Aluno a
        where not exists (
            select 1 from Inscricao i
            where i.aluno = a
              and i.turma.id = :turmaId
        )
        order by a.nome
    """)
    List<Aluno> recuperarAlunosNaoInscritos(@Param("turmaId") Long turmaId);
}