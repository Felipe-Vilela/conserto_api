package com.vilela.felipe.api_2025.model.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        @NotBlank
        String login,
        @NotBlank
        String senha) {
}