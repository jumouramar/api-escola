package com.api.escola.controller;

import com.api.escola.model.Aluno;
import com.api.escola.model.Turma;
import com.api.escola.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Turma>> listar(
            @RequestParam(required = false) Long disciplinaId
    ) {
        if (disciplinaId != null) {
            List<Turma> turmas = turmaService.recuperarTurmasPorDisciplina(disciplinaId);
            return ResponseEntity.ok(turmas);
        }

        return ResponseEntity.ok(turmaService.recuperarTurmas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) {
        Turma turma = turmaService.recuperarTurmaPorId(id);
        return ResponseEntity.ok(turma);
    }

    @GetMapping("/{turmaId}/alunos-inscritos")
    public ResponseEntity<List<Aluno>> listarAlunosInscritos(@PathVariable Long turmaId) {
        List<Aluno> alunos = turmaService.recuperarAlunosInscritos(turmaId);
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{turmaId}/alunos-nao-inscritos")
    public ResponseEntity<List<Aluno>> listarAlunosNaoInscritos(@PathVariable Long turmaId) {
        List<Aluno> alunos = turmaService.recuperarAlunosNaoInscritos(turmaId);
        return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<Turma> cadastrar(@RequestBody Turma turma) {
        return ResponseEntity.ok(turmaService.cadastrarTurma(turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        turmaService.removerTurmaPorId(id);
        return ResponseEntity.noContent().build();
    }
}