package com.api.escola.service;

import com.api.escola.model.Disciplina;
import com.api.escola.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public List<Disciplina> recuperarDisciplinas() { return disciplinaRepository.recuperarDisciplinas(); }

    public Disciplina cadastrarDisciplina(Disciplina disciplina) { return disciplinaRepository.save(disciplina); }

    public void removerDisciplinaPorId(Long id) { disciplinaRepository.deleteById(id);}
}
