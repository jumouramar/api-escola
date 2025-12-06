package com.api.escola.controller;

import com.api.escola.model.Aluno;
import com.api.escola.service.AlunoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> listar(@RequestParam(required = false) Long turmaId) {
        if (turmaId != null) {
            return ResponseEntity.ok(alunoService.recuperarAlunoPorTurma(turmaId));
        }
        return ResponseEntity.ok(alunoService.recuperarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.recuperarAlunoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> cadastrar(@Valid @RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoService.cadastrarAluno(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @Valid @RequestBody Aluno aluno) {
        aluno.setId(id);
        return ResponseEntity.ok(alunoService.alterarAluno(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        alunoService.removerAlunoPorId(id);
        return ResponseEntity.noContent().build();
    }
}