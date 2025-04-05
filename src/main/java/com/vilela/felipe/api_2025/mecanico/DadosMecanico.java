package com.vilela.felipe.api_2025.mecanico;

import jakarta.validation.constraints.NotBlank;

public record DadosMecanico(
        @NotBlank
        String nome,

        String anos_xp) {
}
