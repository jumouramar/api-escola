package com.api.escola.service;

import com.api.escola.exception.EntidadeNaoEncontradaException;
import com.api.escola.model.Aluno;
import com.api.escola.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public List<Aluno> recuperarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Transactional
    public Aluno alterarAluno(Aluno aluno) {
        alunoRepository.findById(aluno.getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Aluno com id = " + aluno.getId() + " não encontrado."));
        return alunoRepository.save(aluno);
    }

    public Aluno recuperarAlunoPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Aluno com id = " + id + " não encontrado."));
    }

    public void removerAlunoPorId(Long id) {
        alunoRepository.deleteById(id);
    }

    public List<Aluno> recuperarAlunoPorTurma(Long turmaId) {
        return alunoRepository.recuperarAlunosPorTurma(turmaId);
    }
}