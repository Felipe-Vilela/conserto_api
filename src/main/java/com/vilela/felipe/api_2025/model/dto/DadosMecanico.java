package com.vilela.felipe.api_2025.model.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosMecanico(
        @NotBlank(message = "É obrigatório informar o campo 'nome'.")
        String nome,

        String anos_xp) {
}
