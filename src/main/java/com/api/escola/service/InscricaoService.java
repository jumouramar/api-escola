package com.api.escola.service;

import com.api.escola.exception.EntidadeNaoEncontradaException;
import com.api.escola.model.Inscricao;
import com.api.escola.model.Aluno;
import com.api.escola.model.Turma;
import com.api.escola.repository.InscricaoRepository;
import com.api.escola.repository.AlunoRepository;
import com.api.escola.repository.TurmaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public List<Inscricao> recuperarInscricoes() {
        return inscricaoRepository.findAll();
    }

    @Transactional
    public Inscricao cadastrarInscricao(Inscricao inscricao) {
        Aluno aluno = alunoRepository.findById(inscricao.getAluno().getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Aluno não encontrado com ID: " + inscricao.getAluno().getId()));

        Turma turma = turmaRepository.findById(inscricao.getTurma().getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Turma não encontrada com ID: " + inscricao.getTurma().getId()));

        inscricao.setAluno(aluno);
        inscricao.setTurma(turma);
        inscricao.setDataHora(LocalDateTime.now());

        return inscricaoRepository.save(inscricao);
    }

    public void removerInscricaoPorId(Long id) {
        inscricaoRepository.deleteById(id);
    }
}