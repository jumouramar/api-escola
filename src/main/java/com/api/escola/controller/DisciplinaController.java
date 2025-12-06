package com.api.escola.controller;

import com.api.escola.model.Disciplina;
import com.api.escola.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<Disciplina>> listar() {
        return ResponseEntity.ok(disciplinaService.recuperarDisciplinas());
    }

    @PostMapping
    public ResponseEntity<Disciplina> cadastrar(@RequestBody Disciplina disciplina) {
        return ResponseEntity.ok(disciplinaService.cadastrarDisciplina(disciplina));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        disciplinaService.removerDisciplinaPorId(id);
        return ResponseEntity.noContent().build();
    }
}