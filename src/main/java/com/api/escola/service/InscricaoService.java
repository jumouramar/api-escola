package com.api.escola.service;

import com.api.escola.exception.EntidadeNaoEncontradaException;
import com.api.escola.model.Inscricao;
import com.api.escola.repository.InscricaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;

    public List<Inscricao> recuperarInscricoes() {
        return inscricaoRepository.findAll();
    }

    public Inscricao cadastrarInscricao(Inscricao inscricao) {
        return inscricaoRepository.save(inscricao);
    }

    public void removerInscricaoPorId(Long id) {
        inscricaoRepository.deleteById(id);
    }
}