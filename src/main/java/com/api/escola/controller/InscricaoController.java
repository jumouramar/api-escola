package com.api.escola.controller;

import com.api.escola.model.Inscricao;
import com.api.escola.service.InscricaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    private final InscricaoService inscricaoService;

    @GetMapping
    public ResponseEntity<List<Inscricao>> listar() {
        return ResponseEntity.ok(inscricaoService.recuperarInscricoes());
    }

    @PostMapping
    public ResponseEntity<Inscricao> cadastrar(@RequestBody Inscricao inscricao) {
        return ResponseEntity.ok(inscricaoService.cadastrarInscricao(inscricao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        inscricaoService.removerInscricaoPorId(id);
        return ResponseEntity.noContent().build();
    }
}