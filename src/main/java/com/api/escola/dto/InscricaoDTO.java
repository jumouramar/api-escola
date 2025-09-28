package com.api.escola.dto;

import java.time.LocalDateTime;

public record InscricaoDTO(Long id, Long alunoId, Long turmaId, LocalDateTime dataHora) {
}