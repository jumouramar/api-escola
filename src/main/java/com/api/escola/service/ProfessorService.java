package com.api.escola.service;

import com.api.escola.exception.EntidadeNaoEncontradaException;
import com.api.escola.model.Professor;
import com.api.escola.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Professor> recuperarProfessores() {
        return professorRepository.findAll();
    }

    public Professor cadastrarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Transactional
    public Professor alterarProfessor(Professor professor) {
        professorRepository.findById(professor.getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Professor com id = " + professor.getId() + " não encontrado."));
        return professorRepository.save(professor);
    }

    public Professor recuperarProfessorPorId(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Professor com id = " + id + " não encontrado."));
    }

    public void removerProfessorPorId(Long id) {
        professorRepository.deleteById(id);
    }
}