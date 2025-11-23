package com.api.escola.service;

import com.api.escola.exception.EntidadeNaoEncontradaException;
import com.api.escola.model.Aluno;
import com.api.escola.model.Turma;
import com.api.escola.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public List<Turma> recuperarTurmas() {
        return turmaRepository.recuperarTurmas();
    }

    public Turma cadastrarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma recuperarTurmaPorId(Long id) {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Turma com id = " + id + " não encontrado."));
    }

    public List<Turma> recuperarTurmasPorDisciplina(Long disciplinaId) {
        return turmaRepository.recuperarTurmasPorDisciplina(disciplinaId);
    }

    public List<Aluno> recuperarAlunosInscritos(Long turmaId) {
        return turmaRepository.recuperarAlunosInscritos(turmaId);
    }

    public List<Aluno> recuperarAlunosNaoInscritos(Long turmaId) {
        return turmaRepository.recuperarAlunosNaoInscritos(turmaId);
    }

    public void removerTurmaPorId(Long id) {
        turmaRepository.deleteById(id);
    }
}